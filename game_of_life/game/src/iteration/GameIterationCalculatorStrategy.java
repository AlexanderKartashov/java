package iteration;

import calculator.ICellNeighbours;
import calculator.ICellStateCalculator;
import type.CellState;
import type.ICell;
import type.ICellsField;

class GameIterationCalculatorStrategy implements IGameIterationCalculatorStrategy {

    public GameIterationCalculatorStrategy(ICellStateCalculator stateCalc) {
        _stateCalc = stateCalc;
    }

    @Override
    public void NextState(ICellsField currentState, ICellsField newState) {
        NextStateImpl(new ReadOnlyCellsFieldProxy(currentState), newState);
    }

    private void NextStateImpl(ICellsField src, ICellsField dst) {
        for(int i = 0; i < src.Width(); ++i) {
            for(int j = 0; j < src.Height(); ++j) {
                dst.SetCellState(i, j,
                        _stateCalc.GetCellState(src.GetCell(i, j), GetNeighbours(i, j, src)));
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
        final ICell top = (y == 0) ? mockDeadCell : src.GetCell(x, y -1);

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

    private final ICellStateCalculator _stateCalc;
}
