package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;

import java.util.List;

public class Bishop extends SlidingPiece {
  private static final List<Direction> moveDirections =
      List.of(
          new Direction(1, 1), new Direction(-1, -1), new Direction(1, -1), new Direction(-1, 1));

  public Bishop(Color color) {
    super(color);
  }

  @Override
  public List<Integer> findPossibleMoves(Position position, int pieceTileIndex) {
    return super.findMovesInDirections(position, pieceTileIndex, moveDirections);
  }

  @Override
  public List<Integer> findControlledTiles(Position position, int pieceTileIndex) {
    return super.findControlledTilesInDirections(position, pieceTileIndex, moveDirections);
  }
}
