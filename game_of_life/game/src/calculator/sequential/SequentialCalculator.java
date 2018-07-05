package calculator.sequential;

import calculator.ICalculationExecutor;
import calculator.ICellNeighbours;
import calculator.cellStateCalculator.ICellStateCalculator;
import type.CellState;
import type.ICellsField;

import java.util.Arrays;

class SequentialCalculator implements ICalculationExecutor {

    public SequentialCalculator(ICellStateCalculator stateCalc) {
        _stateCalc = stateCalc;
    }

    @Override
    public void NextState(ICellsField currentState, ICellsField newState) {
        for(int i = 0; i < currentState.Width(); ++i) {
            for(int j = 0; j < currentState.Height(); ++j) {
                newState.SetCellState(i, j,
                        _stateCalc.GetCellState(currentState.GetCellState(i, j), GetNeighbours(i, j, currentState)));
            }
        }
    }

    private ICellNeighbours GetNeighbours(int x, int y, ICellsField src) {
        final CellState mockDeadCell = CellState.Dead;

        // top left
        final CellState topLeft = (x == 0 || y == 0) ? mockDeadCell : src.GetCellState(x - 1, y - 1);

        // top
        final CellState top = (y == 0) ? mockDeadCell : src.GetCellState(x, y - 1);

        // top right
        final CellState topRight = (y == 0 || x == (src.Width() - 1)) ? mockDeadCell : src.GetCellState(x + 1, y - 1);

        // left
        final CellState left = (x == 0) ? mockDeadCell : src.GetCellState(x - 1, y);

        // right
        final CellState right = (x == (src.Width() - 1)) ? mockDeadCell : src.GetCellState(x + 1, y);

        // bottom left
        final CellState bottomLeft = (x == 0 || y == (src.Height() - 1)) ? mockDeadCell : src.GetCellState(x - 1, y + 1);

        // bottom
        final CellState bottom = (y == (src.Height() - 1)) ? mockDeadCell : src.GetCellState(x, y + 1);

        // bottom right
        final CellState bottomRight = (x == (src.Width() - 1) || y == (src.Height() - 1)) ? mockDeadCell : src.GetCellState(x + 1, y + 1);

        return ()-> {
            final CellState[] states = {topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight};
            return (int)Arrays.stream(states).filter((cell)->cell == CellState.Alive).count();
        };
    }

    @Override
    public void close() throws Exception {
    }

    private final ICellStateCalculator _stateCalc;
}