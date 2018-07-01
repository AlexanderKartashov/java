package calculator.cellStateCalculator;

import calculator.ICellNeighbours;
import type.CellState;
import type.ICell;

public interface ICellStateCalculator {
    CellState GetCellState(ICell currentCell, ICellNeighbours neighbours);
}
