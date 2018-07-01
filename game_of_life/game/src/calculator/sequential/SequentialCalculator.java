package calculator.sequential;

import calculator.ICalculationExecutor;
import calculator.ICellNeighbours;
import calculator.cellStateCalculator.ICellStateCalculator;
import type.CellState;
import type.ICell;
import type.ICellsField;

class SequentialCalculator implements ICalculationExecutor {

    public SequentialCalculator(ICellStateCalculator stateCalc) {
        _stateCalc = stateCalc;
    }

    @Override
    public void NextState(ICellsField currentState, ICellsField newState) {
        for(int i = 0; i < currentState.Width(); ++i) {
            for(int j = 0; j < currentState.Height(); ++j) {
                newState.SetCellState(i, j,
                        _stateCalc.GetCellState(currentState.GetCell(i, j), GetNeighbours(i, j, currentState)));
            }
        }
    }

    private ICellNeighbours GetNeighbours(int x, int y, ICellsField src) {
        final ICell mockDeadCell = new ICell() {
            @Override
            public CellState GetState() {
                return CellState.Dead;
            }
        };

        // top left
        final ICell topLeft = (x == 0 || y == 0) ? mockDeadCell : src.GetCell(x - 1, y - 1);

        // top
        final ICell top = (y == 0) ? mockDeadCell : src.GetCell(x, y - 1);

        // top right
        final ICell topRight = (y == 0 || x == (src.Width() - 1)) ? mockDeadCell : src.GetCell(x + 1, y - 1);

        // left
        final ICell left = (x == 0) ? mockDeadCell : src.GetCell(x - 1, y);

        // right
        final ICell right = (x == (src.Width() - 1)) ? mockDeadCell : src.GetCell(x + 1, y);

        // bottom left
        final ICell bottomLeft = (x == 0 || y == (src.Height() - 1)) ? mockDeadCell : src.GetCell(x - 1, y + 1);

        // bottom
        final ICell bottom = (y == (src.Height() - 1)) ? mockDeadCell : src.GetCell(x, y + 1);

        // bottom right
        final ICell bottomRight = (x == (src.Width() - 1) || y == (src.Height() - 1)) ? mockDeadCell : src.GetCell(x + 1, y + 1);

        return new CellsNeighbours(topLeft, top, topRight, left, right, bottomLeft, bottom, bottomRight);
    }

    @Override
    public void close() throws Exception {
    }

    private final ICellStateCalculator _stateCalc;
}