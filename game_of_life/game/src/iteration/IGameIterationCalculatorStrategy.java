package iteration;

import type.ICellsField;

@FunctionalInterface
public interface IGameIterationCalculatorStrategy {
    void NextState(ICellsField currentState, ICellsField newState);
}
