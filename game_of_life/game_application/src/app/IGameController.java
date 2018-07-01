package app;

import iteration.observer.IGameIterationObservable;

public interface IGameController extends IGameIterationObservable {
        void start();

        void clear();

        void randomFill();
}
