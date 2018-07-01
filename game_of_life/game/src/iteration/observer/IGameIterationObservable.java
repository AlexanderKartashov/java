package iteration.observer;

import type.ICellsField;

public interface IGameIterationObservable {

    void Add(IGameIterationObserver observer);

    void Remove(IGameIterationObserver observer);

    void NotifyObservers();
}
