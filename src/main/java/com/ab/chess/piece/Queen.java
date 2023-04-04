package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;

import java.util.List;

public class Queen extends SlidingPiece {
  private static final List<Direction> moveDirections =
      List.of(
          new Direction(1, 0),
          new Direction(0, 1),
          new Direction(-1, 0),
          new Direction(0, -1),
          new Direction(1, 1),
          new Direction(-1, -1),
          new Direction(1, -1),
          new Direction(-1, 1));

  public Queen(Color color) {
    super(color);
  }

  @Override
  public List<Integer> findPossibleTilesToMove(Position position, int pieceTileIndex) {
    return super.findInDirections(position, pieceTileIndex, moveDirections);
  }
}
