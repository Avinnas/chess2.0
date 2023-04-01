package com.ab.chess.utils;

public class TileHelper {
    public static int column(int tileIndex){
        return tileIndex % 8;
    }

    public static int row(int tileIndex){
        return tileIndex / 8;
    }
}
