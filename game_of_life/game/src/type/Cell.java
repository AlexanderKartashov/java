package type;

class Cell implements IMutableCell {
    @Override
    public void SetState(CellState val) {
        _state = val;
    }

    @Override
    public CellState GetState() {
        return _state;
    }

    private CellState _state = CellState.Dead;
}
