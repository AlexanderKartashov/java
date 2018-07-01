package calculator;

import type.CellState;
import type.ICell;

@FunctionalInterface
public interface IDeadCellStateProcessor {
    CellState GetState(ICellNeighbours neighbours);
}
