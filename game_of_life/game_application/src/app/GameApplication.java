package app;

import iteration.GameIterationFactory;
import iteration.IGameIteration;
import iteration.observer.IGameIterationObserver;
import type.CellState;
import type.CellsField;
import type.ICellsField;

import java.util.ArrayList;
import java.util.List;

public class GameApplication {
    public GameApplication(int w, int h) {
        _currentField = new CellsField(w, h);
        _newFiled = new CellsField(w, h);
        _iteration = new GameIterationFactory().CreateCalculator();
        _controller = new GameController();
        _iteration.Add(_controller);
    }

    public IGameController GetController() {
        return _controller;
    }

    public ICellsField GetCurrentField() { return _currentField; }

    private ICellsField _currentField;
    private ICellsField _newFiled;
    private final IGameIteration _iteration;
    private final GameController _controller;


    private class GameController implements IGameController, IGameIterationObserver {

        @Override
        public void start() {
            CalcNextState();
        }

        @Override
        public synchronized void clear() {
            ClearImpl(_currentField);
            NotifyObservers();
        }

        @Override
        public synchronized void randomFill() {
            final int w = _currentField.Width();
            final int h = _currentField.Height();
            for(int i = 0; i < w; ++i) {
                for(int j = 0; j < h; ++j) {
                    _currentField.SetCellState(i, j, Math.random() > 0.85 ? CellState.Alive : CellState.Dead);
                }
            }
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
        public void HandleEvent() {
            NotifyObservers();
        }

        private synchronized void ClearImpl(ICellsField field) {
            final int w = field.Width();
            final int h = field.Height();
            for(int i = 0; i < w; ++i) {
                for(int j = 0; j < h; ++j) {
                    field.SetCellState(i, j, CellState.Dead);
                }
            }
        }

        private synchronized void CalcNextState() {
            _iteration.NextState(_currentField, _newFiled);
            ICellsField temp = _currentField;
            _currentField = _newFiled;
            _newFiled = temp;
            ClearImpl(_newFiled);
        }

        private final List<IGameIterationObserver> _observers = new ArrayList<>();
    }
}
