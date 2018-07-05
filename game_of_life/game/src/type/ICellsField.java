package type;

public interface ICellsField {
    CellState GetCellState(int x, int y);

    void SetCellState(int x, int y, CellState state);

    int Width();

    int Height();
}
