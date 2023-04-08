package com.ab.chess.piece;

import com.ab.chess.position.Position;

import java.util.List;

public class King extends Piece {
  public King(Color color) {
    super(color);
  }

  @Override
  public List<Integer> findPossibleMoves(Position position, int pieceTileIndex) {
    return null;
  }

  @Override
  public List<Integer> findControlledTiles(Position position, int pieceTileIndex) {
    return null;
  }
}
