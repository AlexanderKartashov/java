package main;

import app.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game of life");

        final ControlsPane buttons = new ControlsPane();
        _canvas = new Canvas(_w, _h);
        final ScrollPane canvasContainer = new ScrollPane(_canvas);
        final VBox grp = new VBox(buttons, canvasContainer);
        final Scene sc = new Scene(grp);
        primaryStage.setScene(sc);
        primaryStage.show();

        _eventListener = new AppEventListener(_app.GetController());
        _controller = new PaneController(
                new CanvasAdapter(_canvas),
                _app,
                buttons,
                _eventListener,
                _executor
        );
    }

    @Override
    public void stop() throws Exception {
        _executor.close();
        _app.close();
    }

    private final int _w = 2700;
    private final int _h = 1600;
    private Canvas _canvas;
    private IGameApplication _app = new ParallelGameAppFactory().CreateApp(_w, _h);
    private PaneController _controller;
    private IAppEventListener _eventListener;
    private ITaskExecutor _executor = new TaskExecutor();
}