package calculator.cellStateCalculator;

@FunctionalInterface
public interface ICellStateCalculatorFactory {
    ICellStateCalculator CreateCalculator();
}
