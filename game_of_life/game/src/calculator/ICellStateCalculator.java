package calculator;

import type.CellState;
import type.ICell;

public interface ICellStateCalculator {
    CellState GetCellState(ICell currentCell, ICellNeighbours neighbours);
}
