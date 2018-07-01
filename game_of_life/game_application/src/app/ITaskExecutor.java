package app;

public interface ITaskExecutor extends AutoCloseable{
    void Execute(Runnable task);
}
