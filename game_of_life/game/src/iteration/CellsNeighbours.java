package iteration;

import calculator.ICellNeighbours;
import type.CellState;
import type.ICell;

import java.util.ArrayList;
import java.util.List;

class CellsNeighbours implements ICellNeighbours {

    public CellsNeighbours(ICell topLeft, ICell top, ICell topRight,
                           ICell left, ICell right,
                           ICell bottomLeft, ICell bottom, ICell bottomRight) {
        _cells.add(topLeft);
        _cells.add(top);
        _cells.add(topRight);
        _cells.add(left);
        _cells.add(right);
        _cells.add(bottomLeft);
        _cells.add(bottom);
        _cells.add(bottomRight);
    }

    private List<ICell> _cells = new ArrayList<>();

    @Override
    public int AliveCount() {
        return (int)_cells.stream().filter((cell)->cell.GetState() == CellState.Alive).count();
    }
}
