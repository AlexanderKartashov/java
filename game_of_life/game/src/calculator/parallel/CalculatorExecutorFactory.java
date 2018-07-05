package calculator.parallel;

import calculator.ICalculationExecutor;
import calculator.ICalculationExecutorFactory;

import java.util.concurrent.ExecutorService;

public class CalculatorExecutorFactory implements ICalculationExecutorFactory {
    public CalculatorExecutorFactory(ExecutorService service, ICalculationExecutor sequentialCalculator, int splitSize) {
        _service = service;
        _sequentialCalculator = sequentialCalculator;
        _splitSize = splitSize;
    }

    @Override
    public ICalculationExecutor CreateExecutor() {
        return new ParallelCalculator(_service, _sequentialCalculator, _splitSize);
    }

    private final int _splitSize;
    private final ExecutorService _service;
    private final ICalculationExecutor _sequentialCalculator;
}
