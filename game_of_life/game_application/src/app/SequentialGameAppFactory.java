package app;

import iteration.IGameIterationFactory;
import iteration.SequentialGameIterationFactory;

public class SequentialGameAppFactory implements IGameApplicationFactory {
    @Override
    public IGameApplication CreateApp(int w, int h) {
        final IGameIterationFactory factory = new SequentialGameIterationFactory();
        return new GameApplication(w, h, factory.CreateCalculator());
    }
}
