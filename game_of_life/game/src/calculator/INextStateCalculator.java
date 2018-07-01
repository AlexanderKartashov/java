package calculator;

import type.ICellsField;

public interface INextStateCalculator extends AutoCloseable {
    void NextState(ICellsField currentState, ICellsField newState) throws InterruptedException;
}
