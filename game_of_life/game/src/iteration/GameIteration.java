package iteration;

import calculator.INextStateCalculator;
import iteration.observer.IGameIterationObserver;
import type.ICellsField;

import java.util.ArrayList;
import java.util.List;

class GameIteration implements IGameIteration {
    public GameIteration(INextStateCalculator calculator) {
        _calculator = calculator;
    }

    @Override
    public void NextState(ICellsField current, ICellsField newState) throws InterruptedException {
        _calculator.NextState(current, newState);
        NotifyObservers();
    }

    @Override
    public synchronized void Add(IGameIterationObserver observer) {
        _observers.add(observer);
    }

    @Override
    public synchronized void Remove(IGameIterationObserver observer) {
        _observers.remove(observer);
    }

    @Override
    public synchronized void NotifyObservers() {
        _observers.forEach(IGameIterationObserver::HandleEvent);
    }

    @Override
    public void close() throws Exception {
        _calculator.close();
    }

    private final List<IGameIterationObserver> _observers = new ArrayList<>();
    private final INextStateCalculator _calculator;
}
