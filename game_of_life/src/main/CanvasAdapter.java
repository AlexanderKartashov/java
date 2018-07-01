package main;

import app.ICanvas;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class CanvasAdapter implements ICanvas {
    public CanvasAdapter(Canvas canvas) {
        _canvas = canvas;
    }

    @Override
    public void SetCellState(int x, int y, boolean alive) {
        final PixelWriter pixelWriter = _canvas.getGraphicsContext2D().getPixelWriter();
        pixelWriter.setColor(x ,y, alive ? Color.BLACK : Color.WHITE);
    }

    private final Canvas _canvas;
}
