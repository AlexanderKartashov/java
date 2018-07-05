package app;

import type.CellState;
import type.ICellsField;

import java.util.concurrent.atomic.AtomicBoolean;

public class PaneController {

    public PaneController(ICanvas canvas, IGameApplication app, IControlPanel pane,
                          IAppEventListener eventListener, ITaskExecutor executor) {
        _canvas = canvas;
        _app = app;
        _pane = pane;
        _executor = executor;
        initPaneCallbacks();
        eventListener.doOnCalcComplete(this::onCalcComplete);

        onClear();
    }

    private void onStart() throws Exception {
        _continue.set(true);
        calcNextState();
    }

    private void onRandom() {
        _app.GetController().randomFill();
    }

    private void onClear(){
        _app.GetController().clear();
    }

    private void onNext() throws Exception {
        _continue.set(false);
        calcNextState();
    }

    private void onStop(){
        _continue.set(false);
    }

    private void calcNextState() throws Exception{
        _pane.calculationInProgress();
        _executor.Execute(()-> {
            try {
                _app.GetController().start();
            } catch (InterruptedException e) {
                _pane.calculationComplete();
            }
        });
    }

    private void onCalcComplete() throws Exception {
        final ICellsField cells = _app.GetCurrentField();
        for(int i = 0; i < cells.Width(); ++i) {
            for (int j = 0; j < cells.Height(); ++j) {
                _canvas.SetCellState(i, j, cells.GetCellState(i, j) == CellState.Alive);
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
    private final IGameApplication _app;
    private final IControlPanel _pane;
    private final ITaskExecutor _executor;
}
