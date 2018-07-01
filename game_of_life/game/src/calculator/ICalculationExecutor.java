package calculator;

import type.ICellsField;

public interface ICalculationExecutor extends AutoCloseable {
    void NextState(ICellsField currentState, ICellsField newState) throws InterruptedException;
}
