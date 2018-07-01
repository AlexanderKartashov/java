package calculator.parallel;

import type.ICell;
import type.ICellsField;

import java.util.ArrayList;
import java.util.List;

public class CellsFieldSplitter {
    List<Pair> split(ICellsField src, ICellsField dst) {
        List<Pair> result = new ArrayList<>();

        final int size = 1000;
        for (int i = 0; i < src.Width(); i = i + size) {
            final int width = ((i + size) > src.Width())
                    ? (src.Width() - i)
                    : size;
            for (int j = 0; j < src.Height(); j = j + size) {
                final int height = ((j + size) > src.Height())
                        ? (src.Height() - j)
                        : size;
                result.add(new Pair(
                        new CellsFieldRegion(src, i, j, width, height),
                        new CellsFieldRegion(dst, i, j, width, height)
                ));
            }
        }

        return result;
    }
}
