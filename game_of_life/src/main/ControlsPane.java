package main;

import app.IActionCallback;
import app.IControlPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

class ControlsPane extends FlowPane implements IControlPanel {
    public ControlsPane() throws Exception{
        super();

        _clear = new Button("Clear");
        _clear.setOnAction(e -> {
            try {
                onClear(e);
            } catch (Exception e1) {
            }
        });

        _random = new Button("Random");
        _random.setOnAction(e -> {
            try {
                onRandom(e);
            } catch (Exception e1) {
            }
        });

        _next = new Button("Next");
        _next.setOnAction(e -> {
            try {
                onNext(e);
            } catch (Exception e1) {
            }
        });

        _run = new Button("Run");
        _run.setOnAction(e -> {
            try {
                onStart(e);
            } catch (Exception e1) {
            }
        });

        _stop = new Button("Stop");
        _stop.setOnAction(e -> {
            try {
                onStop(e);
            } catch (Exception e1) {
            }
        });

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

    private void onStart(ActionEvent e) throws Exception {
        _onStart.onAction();
    }

    private void onClear(ActionEvent e) throws Exception {
        _onClear.onAction();
    }

    private void onRandom(ActionEvent e) throws Exception {
        _onRandom.onAction();
    }

    private void onNext(ActionEvent e) throws Exception {
        _onNext.onAction();
    }

    private void onStop(ActionEvent e) throws Exception {
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
