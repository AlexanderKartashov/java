package iteration;

import calculator.CellStateCalculatorFactory;
import calculator.ICellStateCalculatorFactory;

public class GameIterationFactory {
    public IGameIteration CreateCalculator() {
        final ICellStateCalculatorFactory stateCalculatorFactory = new CellStateCalculatorFactory();
        return new GameIteration(new GameIterationCalculatorStrategy(stateCalculatorFactory.CreateCalculator()));
    }
}
