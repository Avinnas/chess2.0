package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.move.TileIterator;
import com.ab.chess.position.Position;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

  private static final List<Direction> moveDirections =
      List.of(
          new Direction(2, 1),
          new Direction(2, -1),
          new Direction(-2, 1),
          new Direction(-2, -1),
          new Direction(-1, 2),
          new Direction(-1, -2),
          new Direction(1, -2),
          new Direction(1, 2));

  public Knight(Color color) {
    super(color);
  }

  @Override
  public List<Integer> findPossibleTilesToMove(Position position, int tileIndex) {

    List<Integer> moves = new ArrayList<>();

    for (Direction direction : moveDirections) {
      TileIterator iterator = new TileIterator(tileIndex, direction);
      if (iterator.hasNext()) {
        int currentTile = iterator.next();
        if (moveIsValid(position, tileIndex)) {
          moves.add(currentTile);
        }
      }
    }
    return moves;
  }

  private boolean moveIsValid(Position position, int tile) {
    if (position.tileOccupiedByFriend(tile, color)) {
      return false;
    }
    return true;
  }
}
