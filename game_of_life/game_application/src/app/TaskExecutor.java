package app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor implements ITaskExecutor {
    public TaskExecutor() {
        _service = Executors.newSingleThreadExecutor();
    }

    @Override
    public void Execute(Runnable task) {
        _service.execute(task);
    }

    @Override
    public void close() throws Exception {
        _service.shutdown();
    }

    private final ExecutorService _service;
}
