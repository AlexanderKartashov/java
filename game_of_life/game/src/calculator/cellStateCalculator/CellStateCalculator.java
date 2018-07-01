package calculator.cellStateCalculator;

import calculator.ICellNeighbours;
import calculator.cellStateCalculator.IAliveCellStateProcessor;
import calculator.cellStateCalculator.ICellStateCalculator;
import calculator.cellStateCalculator.IDeadCellStateProcessor;
import type.CellState;
import type.ICell;

class CellStateCalculator implements ICellStateCalculator {

    public CellStateCalculator(IDeadCellStateProcessor deadCell, IAliveCellStateProcessor aliveCell) {
        _deadCell = deadCell;
        _aliveCell = aliveCell;
    }

    @Override
    public CellState GetCellState(ICell currentCell, ICellNeighbours neighbours) {
        return currentCell.GetState() == CellState.Alive ?
                _aliveCell.GetState(neighbours) :
                _deadCell.GetState(neighbours);
    }

    private final IDeadCellStateProcessor _deadCell;
    private final IAliveCellStateProcessor _aliveCell;
}
