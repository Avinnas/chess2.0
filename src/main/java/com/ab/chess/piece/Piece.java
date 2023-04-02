package com.ab.chess.piece;

import com.ab.chess.position.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public abstract class Piece {
    protected Color color;

    public abstract List<Integer> findPossibleTilesToMove(Position position, int pieceTileIndex);
}
