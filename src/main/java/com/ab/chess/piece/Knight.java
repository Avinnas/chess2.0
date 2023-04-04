package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.move.MoveList;
import com.ab.chess.move.TileIterator;
import com.ab.chess.position.Position;
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

    MoveList moveList = new MoveList(position,  this);

    for (Direction direction : moveDirections){
      TileIterator iterator = new TileIterator(tileIndex, direction);
      if(iterator.hasNext()){
        moveList.add(iterator.next());
      }
    }

    return moveList.getMoves();
  }
}
