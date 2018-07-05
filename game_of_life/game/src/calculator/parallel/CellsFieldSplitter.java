package calculator.parallel;

import type.ICellsField;

import java.util.ArrayList;
import java.util.List;

public class CellsFieldSplitter {
    List<Pair> split(ICellsField src, ICellsField dst, int splitSize) {
        List<Pair> result = new ArrayList<>();

        for (int i = 0; i < src.Width(); i = i + splitSize) {
            final int width = ((i + splitSize) > src.Width())
                    ? (src.Width() - i)
                    : splitSize;
            for (int j = 0; j < src.Height(); j = j + splitSize) {
                final int height = ((j + splitSize) > src.Height())
                        ? (src.Height() - j)
                        : splitSize;
                result.add(new Pair(
                        new CellsFieldRegion(src, i, j, width, height),
                        new CellsFieldRegion(dst, i, j, width, height)
                ));
            }
        }

        return result;
    }
}
