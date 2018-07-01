package main;

import app.GameApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import type.CellState;
import type.ICellsField;

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

        _controller = new PaneController(
                new CanvasAdapter(_canvas),
                _app,
                buttons
        );
    }

    private final int _w = 3000;
    private final int _h = 2000;
    private Canvas _canvas;
    private GameApplication _app = new GameApplication(_w, _h);
    private PaneController _controller;
}