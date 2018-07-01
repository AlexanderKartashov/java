package calculator.parallel;

import type.ICellsField;

public class Pair {

    public Pair(ICellsField src, ICellsField dst) {
        _src = src;
        _dst = dst;
    }

    public ICellsField src() {
        return _src;
    }

    public ICellsField dst() {
        return _dst;
    }

    private final ICellsField _src;
    private final ICellsField _dst;
}
