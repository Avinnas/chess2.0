package com.ab.chess.move;

import com.ab.chess.position.Position;

import java.util.List;

public class MoveFinder {
  public List<Move> findLegalMoves(Position position) {
    return findPseudoLegalMoves(position);
  }

  public List<Move> findPseudoLegalMoves(Position position) {
    return null;
  }
}
