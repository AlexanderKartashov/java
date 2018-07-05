package calculator.cellStateCalculator;

import calculator.ICellNeighbours;
import type.CellState;

class CellStateCalculator implements ICellStateCalculator {

    public CellStateCalculator(IDeadCellStateProcessor deadCell, IAliveCellStateProcessor aliveCell) {
        _deadCell = deadCell;
        _aliveCell = aliveCell;
    }

    @Override
    public CellState GetCellState(CellState currentCell, ICellNeighbours neighbours) {
        return currentCell == CellState.Alive ?
                _aliveCell.GetState(neighbours) :
                _deadCell.GetState(neighbours);
    }

    private final IDeadCellStateProcessor _deadCell;
    private final IAliveCellStateProcessor _aliveCell;
}
