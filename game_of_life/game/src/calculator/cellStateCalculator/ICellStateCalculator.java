package calculator.cellStateCalculator;

import calculator.ICellNeighbours;
import type.CellState;

public interface ICellStateCalculator {
    CellState GetCellState(CellState currentCell, ICellNeighbours neighbours);
}
