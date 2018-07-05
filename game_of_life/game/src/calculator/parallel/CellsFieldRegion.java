package calculator.parallel;

import type.CellState;
import type.ICellsField;

class CellsFieldRegion implements ICellsField {

    public CellsFieldRegion(ICellsField field, int startX, int startY, int width, int height) {
        _field = field;
        _startX = startX;
        _startY = startY;
        _width = width;
        _height = height;
    }

    @Override
    public CellState GetCellState(int x, int y) {
        return _field.GetCellState(
                getRealCoordinate(_startX, x),
                getRealCoordinate(_startY, y)
        );
    }

    @Override
    public void SetCellState(int x, int y, CellState state) {
        _field.SetCellState(
                getRealCoordinate(_startX, x),
                getRealCoordinate(_startY, y),
                state
        );
    }

    @Override
    public int Width() {
        return _width;
    }

    @Override
    public int Height() {
        return _height;
    }

    private int getRealCoordinate(int start, int coordinate) {
        return start + coordinate;
    }

    private final ICellsField _field;
    private final int _startX;
    private final int _startY;
    private final int _width;
    private final int _height;
}