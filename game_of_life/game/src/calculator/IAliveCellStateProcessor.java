package calculator;

import type.CellState;
import type.ICell;

@FunctionalInterface
public interface IAliveCellStateProcessor {
    CellState GetState(ICellNeighbours neighbours);
}
