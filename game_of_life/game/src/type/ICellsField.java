package type;

public interface ICellsField {
    ICell GetCell(int x, int y);

    void SetCellState(int x, int y, CellState state);

    int Width();

    int Height();
}
