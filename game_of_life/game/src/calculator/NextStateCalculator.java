package calculator;

import type.ICellsField;

public class NextStateCalculator implements INextStateCalculator {

    public NextStateCalculator(ICalculationExecutor calculator) {
        _calculator = calculator;
    }

    @Override
    public void NextState(ICellsField currentState, ICellsField newState) throws InterruptedException {
        _calculator.NextState(new ReadOnlyCellsFieldProxy(currentState), newState);
    }

    @Override
    public void close() throws Exception {
        _calculator.close();
    }

    private final ICalculationExecutor _calculator;
}