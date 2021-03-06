package app;

import iteration.observer.IGameIterationObservable;

public interface IGameController extends IGameIterationObservable {
        void start() throws InterruptedException;

        void clear();

        void randomFill();
}
