package calculator.cellStateCalculator;

import calculator.ICellNeighbours;
import type.CellState;

@FunctionalInterface
public interface IAliveCellStateProcessor {
    CellState GetState(ICellNeighbours neighbours);
}
