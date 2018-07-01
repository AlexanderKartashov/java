package iteration;

import calculator.ICalculationExecutorFactory;
import calculator.NextStateCalculator;
import calculator.cellStateCalculator.CellStateCalculatorFactory;
import calculator.cellStateCalculator.ICellStateCalculatorFactory;

import java.util.concurrent.Executors;

public class ParallelGameIterationFactory implements IGameIterationFactory {
    @Override
    public IGameIteration CreateCalculator() {
        final ICellStateCalculatorFactory stateCalculatorFactory = new CellStateCalculatorFactory();
        final ICalculationExecutorFactory seqExecutorFactory = new calculator.sequential.CalculatorExecutorFactory(stateCalculatorFactory.CreateCalculator());
        final ICalculationExecutorFactory executorFactory = new calculator.parallel.CalculatorExecutorFactory(
                Executors.newCachedThreadPool(),
                seqExecutorFactory.CreateExecutor());
        return new GameIteration(new NextStateCalculator(executorFactory.CreateExecutor()));
    }
}
