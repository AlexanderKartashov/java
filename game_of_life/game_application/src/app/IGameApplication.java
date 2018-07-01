package app;

import type.ICellsField;

public interface IGameApplication extends AutoCloseable{

    IGameController GetController();

    ICellsField GetCurrentField();
}
