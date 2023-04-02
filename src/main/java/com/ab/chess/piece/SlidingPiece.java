package com.ab.chess.piece;

import com.ab.chess.position.Position;

import java.util.List;

public abstract class SlidingPiece extends Piece{
    public SlidingPiece(Color color) {
        super(color);
    }

    public List<Integer> findInDirection(Position position, int pieceTileIndex) {
        return null;
    }
}
