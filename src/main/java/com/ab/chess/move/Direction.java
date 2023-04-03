package com.ab.chess.move;

import com.ab.chess.utils.TileHelper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Direction {
    private final int x;
    private final int y;

    public int moveOneStep(int startTile){
        return startTile + y * 8 + x;
    }

    public boolean isStepPossible(int startTile){
        int nextColumn = TileHelper.column(startTile) + x;
        int nextRow = TileHelper.row(startTile) + y;
        return inBounds(nextRow) && inBounds(nextColumn);
    }

    private boolean inBounds(int index){
        return index <= 7 && index >= 0;
    }
}
