package iteration;

import calculator.ICalculationExecutorFactory;
import calculator.cellStateCalculator.CellStateCalculatorFactory;
import calculator.cellStateCalculator.ICellStateCalculatorFactory;
import calculator.NextStateCalculator;
import calculator.sequential.CalculatorExecutorFactory;

public class SequentialGameIterationFactory implements IGameIterationFactory {
    public IGameIteration CreateCalculator() {
        final ICellStateCalculatorFactory stateCalculatorFactory = new CellStateCalculatorFactory();
        final ICalculationExecutorFactory executorFactory = new CalculatorExecutorFactory(stateCalculatorFactory.CreateCalculator());
        return new GameIteration(new NextStateCalculator(executorFactory.CreateExecutor()));
    }
}
