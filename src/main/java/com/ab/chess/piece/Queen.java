package com.ab.chess.piece;

import com.ab.chess.position.Position;

import java.util.List;

public class Queen extends SlidingPiece{
    public Queen(Color color) {
        super(color);
    }

    @Override
    public List<Integer> findPossibleTilesToMove(Position position, int pieceTileIndex) {
        return null;
    }
}
