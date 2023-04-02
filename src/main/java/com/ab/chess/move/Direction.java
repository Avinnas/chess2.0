package com.ab.chess.move;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Direction {
    private final int x;
    private final int y;

    public int moveOneStep(){
        return y * 8 + x;
    }
}
