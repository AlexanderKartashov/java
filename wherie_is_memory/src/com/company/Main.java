package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        Cell[][] cells = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int w = 10000;
        final int h = 10000;
        while(!reader.readLine().isEmpty()){
            cells = new Cell[w][h];
            for(int i = 0; i < w; ++i) {
                for (int j = 0; j < h; ++j) {
                    cells[i][j] = new Cell();
                }
            }
            System.out.println("ready");
        }
    }
}


enum State {
    Dead,
    Alive
}

class Cell {

    public State getState() {
        return _state;
    }

    public void setState(State val) {
        _state = val;
    }


    private State _state = State.Dead;
}