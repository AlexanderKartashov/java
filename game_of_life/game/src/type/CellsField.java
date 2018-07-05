package type;

import java.util.ArrayList;
import java.util.List;

public class CellsField implements ICellsField {
    public CellsField(int width, int height) {
        _width = width;
        _height = height;

        _cells = new CellState[_width][_height];
        for(int i = 0; i < _width; ++i){
            for(int j = 0; j < _height; ++j) {
                _cells[i][j] = CellState.Dead;
            }
        }
    }

    @Override
    public CellState GetCellState(int x, int y) {
        ValidateIndices(x, y);
        return _cells[x][y];
    }

    @Override
    public void SetCellState(int x, int y, CellState state) {
        ValidateIndices(x, y);
        _cells[x][y] = state;
    }

    @Override
    public int Width() {
        return _width;
    }

    @Override
    public int Height() {
        return _height;
    }

    private void ValidateIndices(int x, int y) {
        if ((x < 0 || x > _width) ||
                (y < 0 || y > _height)) {
            throw new IllegalArgumentException("invalid index");
        }
    }

    private CellState[][] _cells;
    private final int _width;
    private final int _height;
}
