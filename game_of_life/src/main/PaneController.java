package main;

import app.GameApplication;
import javafx.application.Platform;
import sun.util.resources.pl.CalendarData_pl;
import type.CellState;
import type.ICellsField;

import java.util.concurrent.atomic.AtomicBoolean;

public class PaneController {

    public PaneController(ICanvas canvas, GameApplication app, IControlPanel pane) {
        _canvas = canvas;
        _app = app;
        _pane = pane;
        initPaneCallbacks();
        _app.GetController().Add(()->{
            Platform.runLater(this::onCalcComplete);
        });
        onClear();
    }

    private void onStart() {
        _continue.set(true);
        calcNextState();
    }

    private void onRandom() {
        _app.GetController().randomFill();
    }

    private void onClear(){
        _app.GetController().clear();
    }

    private void onNext() {
        _continue.set(false);
        calcNextState();
    }

    private void onStop(){
        _continue.set(false);
    }

    private void calcNextState(){
        _pane.calculationInProgress();
        final Runnable task = new Runnable() {
            @Override
            public void run() {
                _app.GetController().start();
            }
        };
        task.run();
    }

    private void onCalcComplete() {
        final ICellsField cells = _app.GetCurrentField();
        for(int i = 0; i < cells.Width(); ++i) {
            for (int j = 0; j < cells.Height(); ++j) {
                _canvas.SetCellState(i, j, cells.GetCell(i, j).GetState() == CellState.Alive);
            }
        }

        if (_continue.get()) {
            onStart();
        }
        else {
            _pane.calculationComplete();
        }
    }

    private void initPaneCallbacks() {
        _pane.doOnClear(this::onClear);
        _pane.doOnRandom(this::onRandom);
        _pane.doOnNext(this::onNext);
        _pane.doOnStart(this::onStart);
        _pane.doOnStop(this::onStop);
    }

    private AtomicBoolean _continue = new AtomicBoolean(false);
    private final ICanvas _canvas;
    private final GameApplication _app;
    private final IControlPanel _pane;
}
