package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.move.SearchMode;
import com.ab.chess.move.TileIterator;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
  private static final List<Direction> moveDirections =
      List.of(
          Direction.UP,
          Direction.DOWN,
          Direction.LEFT,
          Direction.RIGHT,
          Direction.LEFT_UP,
          Direction.RIGHT_UP,
          Direction.LEFT_DOWN,
          Direction.RIGHT_DOWN);

  public King(Color color) {
    super(color);
  }

  @Override
  public List<Integer> findPossibleMoves(Position position, int pieceTileIndex) {
    return findTiles(position, pieceTileIndex, SearchMode.POSSIBLE_MOVES);
  }

  @Override
  public List<Integer> findControlledTiles(Position position, int pieceTileIndex) {
    return findTiles(position, pieceTileIndex, SearchMode.CONTROLLED_TILES);
  }

  // TODO: refactor - nesting
  private List<Integer> findTiles(Position position, int pieceTileIndex, SearchMode searchMode) {
    List<Integer> moves = new ArrayList<>();
    for (Direction direction : moveDirections) {
      TileIterator iterator = new TileIterator(pieceTileIndex, direction);
      if (iterator.hasNext()) {
        int currentTile = iterator.next();
        switch (searchMode) {
          case POSSIBLE_MOVES -> {
            if (!position.tileOccupiedByFriend(currentTile, color)) {
              moves.add(currentTile);
            }
          }
          case CONTROLLED_TILES -> moves.add(currentTile);
        }
      }
    }
    return moves;
  }
}
