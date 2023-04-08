package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.move.SearchMode;
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
  public List<Integer> findPossibleMoves(Position position, int tileIndex) {
    return findTiles(position, tileIndex, SearchMode.POSSIBLE_MOVES);
  }

  public List<Integer> findControlledTiles(Position position, int tileIndex) {

    return findTiles(position, tileIndex, SearchMode.CONTROLLED_TILES);
  }

  private List<Integer> findTiles(Position position, int tileIndex, SearchMode searchMode) {
    List<Integer> moves = new ArrayList<>();

    for (Direction direction : moveDirections) {
      TileIterator iterator = new TileIterator(tileIndex, direction);
      if (iterator.hasNext()) {
        int currentTile = iterator.next();
        if (moveIsValid(position, currentTile) || searchMode == SearchMode.CONTROLLED_TILES) {
          moves.add(currentTile);
        }
      }
    }
    return moves;
  }

  private boolean moveIsValid(Position position, int tile) {
    return !position.tileOccupiedByFriend(tile, color);
  }
}
