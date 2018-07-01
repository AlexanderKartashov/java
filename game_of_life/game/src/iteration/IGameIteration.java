package iteration;

import iteration.observer.IGameIterationObservable;
import type.ICellsField;

public interface IGameIteration extends IGameIterationObservable {
    void NextState(ICellsField current, ICellsField newState);
}
