package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class SlidingPiece extends Piece {
  public SlidingPiece(Color color) {
    super(color);
  }

  public List<Integer> findInDirections(
      Position position, int tileIndex, List<Direction> directions) {
    List<Integer> moves = new ArrayList<>();
    for (Direction direction : directions) {
      moves.addAll(findInDirection(position, tileIndex, direction));
    }
    return moves;
  }

  public List<Integer> findInDirection(Position position, int tileIndex, Direction direction) {
    int currentIndex = tileIndex;
    List<Integer> moves = new ArrayList<>();

    while (direction.isStepPossible(currentIndex)) {
      currentIndex = direction.moveOneStep(currentIndex);
      if (position.tileOccupiedByFriend(currentIndex, color)) {
        break;
      }
      moves.add(currentIndex);
      if(position.tileOccupiedByEnemy(currentIndex, color)){
        break;
      }

    }
    return moves;
  }
}
