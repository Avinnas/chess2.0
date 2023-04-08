package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.move.SearchMode;
import com.ab.chess.move.TileIterator;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class SlidingPiece extends Piece {
  public SlidingPiece(Color color) {
    super(color);
  }

  public List<Integer> findMovesInDirections(
      Position position, int tileIndex, List<Direction> directions) {
    return findInDirections(position, tileIndex, directions, SearchMode.POSSIBLE_MOVES);
  }

  public List<Integer> findControlledTilesInDirections(
      Position position, int tileIndex, List<Direction> directions) {
    return findInDirections(position, tileIndex, directions, SearchMode.CONTROLLED_TILES);
  }

  public List<Integer> findInDirections(
      Position position, int tileIndex, List<Direction> directions, SearchMode searchMode) {
    List<Integer> moves = new ArrayList<>();
    for (Direction direction : directions) {
      moves.addAll(findInDirection(position, tileIndex, direction, searchMode));
    }
    return moves;
  }

  public List<Integer> findInDirection(
      Position position, int tileIndex, Direction direction, SearchMode searchMode) {
    List<Integer> moves = new ArrayList<>();
    TileIterator iterator = new TileIterator(tileIndex, direction);

    while (iterator.hasNext()) {
      int currentIndex = iterator.next();
      if (position.tileOccupiedByFriend(currentIndex, color)) {
        if (searchMode == SearchMode.CONTROLLED_TILES) {
          moves.add(currentIndex);
        }
        break;
      }
      moves.add(currentIndex);
      if (position.tileOccupiedByEnemy(currentIndex, color)) {
        break;
      }
    }
    return moves;
  }

  }
