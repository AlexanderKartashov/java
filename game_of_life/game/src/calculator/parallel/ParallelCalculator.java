package calculator.parallel;

import calculator.ICalculationExecutor;
import type.ICellsField;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public class ParallelCalculator implements ICalculationExecutor {
    public ParallelCalculator(ExecutorService service, ICalculationExecutor sequentialCalculator, int splitSize) {
        _service = service;
        _sequentialCalculator = sequentialCalculator;
        _splitSize = splitSize;
    }

    @Override
    public void NextState(ICellsField currentState, ICellsField newState) throws InterruptedException {
        final List<Pair> pairs = _splitter.split(currentState, newState, _splitSize);
        _service.invokeAll(pairs.stream().map((pair)-> (Callable<Void>) () -> {
            _sequentialCalculator.NextState(pair.src(), pair.dst());
            return null;
        }).collect(Collectors.toList()));
    }

    @Override
    public void close() throws Exception {
        _service.shutdown();
        _sequentialCalculator.close();
    }

    private final ExecutorService _service;
    private final int _splitSize;
    private final CellsFieldSplitter _splitter = new CellsFieldSplitter();
    private final ICalculationExecutor _sequentialCalculator;
}
