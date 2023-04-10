package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;
import java.util.List;

public class Bishop extends SlidingPiece {
  private static final List<Direction> moveDirections =
          List.of(
                  Direction.LEFT_UP,
                  Direction.RIGHT_UP,
                  Direction.LEFT_DOWN,
                  Direction.RIGHT_DOWN);

  public Bishop(Color color, int tileIndex) {
    super(color, tileIndex);
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
