package calculator.cellStateCalculator;

import calculator.ICellNeighbours;
import type.CellState;

@FunctionalInterface
public interface IDeadCellStateProcessor {
    CellState GetState(ICellNeighbours neighbours);
}
