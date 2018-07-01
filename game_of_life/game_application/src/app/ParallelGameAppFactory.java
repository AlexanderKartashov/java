package app;

import iteration.IGameIterationFactory;
import iteration.ParallelGameIterationFactory;
import iteration.SequentialGameIterationFactory;

public class ParallelGameAppFactory implements IGameApplicationFactory {
    @Override
    public IGameApplication CreateApp(int w, int h) {
        final IGameIterationFactory factory = new ParallelGameIterationFactory();
        return new GameApplication(w, h, factory.CreateCalculator());
    }
}
