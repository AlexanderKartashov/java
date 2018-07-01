package type;

import java.util.ArrayList;
import java.util.List;

public class CellsField implements ICellsField {
    public CellsField(int width, int height) {
        _width = width;
        _height = height;

        _cells = new ArrayList<>();
        for(int i = 0; i < _width; ++i){
            List<IMutableCell> cellsRow = new ArrayList<>();
            for(int j = 0; j < _height; ++j) {
                cellsRow.add(new Cell());
            }
            _cells.add(cellsRow);
        }
    }

    @Override
    public ICell GetCell(int x, int y) {
        ValidateIndices(x, y);
        return _cells.get(x).get(y);
    }

    @Override
    public void SetCellState(int x, int y, CellState state) {
        ValidateIndices(x, y);
        _cells.get(x).get(y).SetState(state);
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

    private List<List<IMutableCell>> _cells;
    private final int _width;
    private final int _height;
}
