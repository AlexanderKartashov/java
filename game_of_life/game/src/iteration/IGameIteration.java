package iteration;

import iteration.observer.IGameIterationObservable;
import type.ICellsField;

public interface IGameIteration extends IGameIterationObservable, AutoCloseable {
    void NextState(ICellsField current, ICellsField newState) throws InterruptedException;
}
