package calculator;

@FunctionalInterface
public interface ICellStateCalculatorFactory {
    ICellStateCalculator CreateCalculator();
}
