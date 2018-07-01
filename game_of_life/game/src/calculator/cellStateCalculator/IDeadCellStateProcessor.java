package calculator.cellStateCalculator;

import calculator.ICellNeighbours;
import type.CellState;
import type.ICell;

@FunctionalInterface
public interface IDeadCellStateProcessor {
    CellState GetState(ICellNeighbours neighbours);
}
