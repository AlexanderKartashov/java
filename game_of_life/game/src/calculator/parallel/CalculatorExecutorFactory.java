package calculator.parallel;

import calculator.ICalculationExecutor;
import calculator.ICalculationExecutorFactory;

import java.util.concurrent.ExecutorService;

public class CalculatorExecutorFactory implements ICalculationExecutorFactory {
    public CalculatorExecutorFactory(ExecutorService service, ICalculationExecutor sequentialCalculator) {
        _service = service;
        _sequentialCalculator = sequentialCalculator;
    }

    @Override
    public ICalculationExecutor CreateExecutor() {
        return new ParallelCalculator(_service, _sequentialCalculator);
    }

    private final ExecutorService _service;
    private final ICalculationExecutor _sequentialCalculator;
}
