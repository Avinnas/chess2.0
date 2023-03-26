package com.ab.chess.position;

import com.ab.chess.piece.*;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Position {
    private Map<Integer, Piece> pieces = new HashMap<>();

    private Position(Map<Integer, Piece> pieces){
        this.pieces = pieces;
    }

    public static Position createStartingPosition() {
        Map<Integer, Piece> pieces = new HashMap<>();
        pieces.put(0, new Rook(Color.WHITE));
        pieces.put(1, new Knight(Color.WHITE));
        pieces.put(2, new Bishop(Color.WHITE));
        pieces.put(3, new Queen(Color.WHITE));
        pieces.put(4, new King(Color.WHITE));
        pieces.put(5, new Bishop(Color.WHITE));
        pieces.put(6, new Knight(Color.WHITE));
        pieces.put(7, new Rook(Color.WHITE));

        for (int i = 8; i < 16; i++) {
            pieces.put(i, new Pawn(Color.WHITE));
        }

        for (int i = 48; i < 56; i++) {
            pieces.put(i, new Pawn(Color.WHITE));
        }

        pieces.put(56, new Rook(Color.WHITE));
        pieces.put(57, new Knight(Color.WHITE));
        pieces.put(58, new Bishop(Color.WHITE));
        pieces.put(59, new Queen(Color.WHITE));
        pieces.put(60, new King(Color.WHITE));
        pieces.put(61, new Bishop(Color.WHITE));
        pieces.put(62, new Knight(Color.WHITE));
        pieces.put(63, new Rook(Color.WHITE));

        return new Position(pieces);
    }
}
