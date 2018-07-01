package app;

@FunctionalInterface
public interface IGameApplicationFactory {
    IGameApplication CreateApp(int w, int h);
}
