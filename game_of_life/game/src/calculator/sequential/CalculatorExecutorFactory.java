package calculator.sequential;

import calculator.ICalculationExecutor;
import calculator.ICalculationExecutorFactory;
import calculator.cellStateCalculator.ICellStateCalculator;

public class CalculatorExecutorFactory implements ICalculationExecutorFactory {
    public CalculatorExecutorFactory(ICellStateCalculator calc) {
        _calc = calc;
    }

    @Override
    public ICalculationExecutor CreateExecutor() {
        return new SequentialCalculator(_calc);
    }

    private final ICellStateCalculator _calc;
}
