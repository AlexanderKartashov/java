package calculator;

@FunctionalInterface
public interface ICalculationExecutorFactory {
    ICalculationExecutor CreateExecutor();
}
