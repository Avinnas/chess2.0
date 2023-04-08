package com.ab.chess.move;

public record Direction(int x, int y) {
    public static Direction UP = new Direction(0, 1);
    public static Direction DOWN = new Direction(0, -1);
}
