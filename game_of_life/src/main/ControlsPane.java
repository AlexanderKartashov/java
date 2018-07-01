package main;

import app.IGameController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

class ControlsPane extends FlowPane implements IControlPanel {
    public ControlsPane(){
        super();

        _clear = new Button("Clear");
        _clear.setOnAction(this::onClear);

        _random = new Button("Random");
        _random.setOnAction(this::onRandom);

        _next = new Button("Next");
        _next.setOnAction(this::onNext);

        _run = new Button("Run");
        _run.setOnAction(this::onStart);

        _stop = new Button("Stop");
        _stop.setOnAction(this::onStop);

        setAlignment(Pos.CENTER);

        getChildren().addAll(_clear, _random, _next, _run, _stop);
    }

    @Override
    public void doOnClear(IActionCallback callback) {
        _onClear = callback;
    }

    @Override
    public void doOnRandom(IActionCallback callback) {
        _onRandom = callback;
    }

    @Override
    public void doOnNext(IActionCallback callback) {
        _onNext = callback;
    }

    @Override
    public void doOnStart(IActionCallback callback) {
        _onStart = callback;
    }

    @Override
    public void doOnStop(IActionCallback callback) {
        _onStop = callback;
    }

    @Override
    public void calculationComplete() {
        _run.setDisable(false);
        _clear.setDisable(false);
        _next.setDisable(false);
        _random.setDisable(false);
        _stop.setDisable(true);
    }

    @Override
    public void calculationInProgress() {
        _run.setDisable(true);
        _clear.setDisable(true);
        _next.setDisable(true);
        _random.setDisable(true);
        _stop.setDisable(false);
    }

    private void onStart(ActionEvent e) {
        _onStart.onAction();
    }

    private void onClear(ActionEvent e){
        _onClear.onAction();
    }

    private void onRandom(ActionEvent e) {
        _onRandom.onAction();
    }

    private void onNext(ActionEvent e) {
        _onNext.onAction();
    }

    private void onStop(ActionEvent e) {
        _onStop.onAction();
    }

    private IActionCallback _onClear;
    private IActionCallback _onRandom;
    private IActionCallback _onNext;
    private IActionCallback _onStart;
    private IActionCallback _onStop;
    private final Button _clear;
    private final Button _random;
    private final Button _next;
    private final Button _run;
    private final Button _stop;
}
