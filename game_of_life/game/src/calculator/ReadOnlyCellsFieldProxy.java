package calculator;

import type.CellState;
import type.ICellsField;

class ReadOnlyCellsFieldProxy implements ICellsField {

    public ReadOnlyCellsFieldProxy(ICellsField realObject) {
        _realObject = realObject;
    }

    @Override
    public CellState GetCellState(int x, int y) {
        return _realObject.GetCellState(x, y);
    }

    @Override
    public void SetCellState(int x, int y, CellState state) {
        throw new IllegalStateException("Cells state is read only");
    }

    @Override
    public int Width() {
        return _realObject.Width();
    }

    @Override
    public int Height() {
        return _realObject.Height();
    }

    private final ICellsField _realObject;
}
