package calculator.cellStateCalculator;

import type.CellState;

public class CellStateCalculatorFactory implements ICellStateCalculatorFactory {

    @Override
    public ICellStateCalculator CreateCalculator() {
        return new CellStateCalculator(
                (neighbours) -> (neighbours.AliveCount() == 3) ? CellState.Alive : CellState.Dead,
                (neighbours) -> (neighbours.AliveCount() < 2 || neighbours.AliveCount() > 3) ? CellState.Dead : CellState.Alive);
    }
}
