package com.ab.chess.piece;

import com.ab.chess.position.Position;

import java.util.List;

public class Bishop extends SlidingPiece{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public List<Integer> findPossibleTilesToMove(Position position, int pieceTileIndex) {
        return null;
    }
}
