package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;
import java.util.List;

public class Rook extends SlidingPiece {

  private static final List<Direction> moveDirections = Direction.STRAIGHT;

  public Rook(Color color, int tileIndex) {
    super(color, tileIndex);
  }

  @Override
  public List<Direction> getMoveDirections() {
    return moveDirections;
  }

  @Override
  public List<Integer> findPossibleMoves(Position position) {
    return super.findMovesInDirections(position, moveDirections);
  }

  @Override
  public List<Integer> findControlledTiles(Position position) {
    return super.findControlledTilesInDirections(position, moveDirections);
  }
}
