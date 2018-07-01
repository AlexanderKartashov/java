package main;

interface IControlPanel {
    void doOnClear(IActionCallback callback);
    void doOnRandom(IActionCallback callback);
    void doOnNext(IActionCallback callback);
    void doOnStart(IActionCallback callback);
    void doOnStop(IActionCallback callback);

    void calculationComplete();
    void calculationInProgress();
}
