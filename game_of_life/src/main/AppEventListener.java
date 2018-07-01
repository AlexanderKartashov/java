package main;

import app.IAction;
import app.IAppEventListener;
import iteration.observer.IGameIterationObservable;
import javafx.application.Platform;

public class AppEventListener implements IAppEventListener {
    public AppEventListener(IGameIterationObservable observable) {
        observable.Add(()->{
            if (_action != null) {
                Platform.runLater(() -> {
                    try {
                        _action.action();
                    } catch (Exception e) {
                    }
                });
            }
        });
    }

    @Override
    public void doOnCalcComplete(IAction action) {
        _action = action;
    }

    private IAction _action;
}
