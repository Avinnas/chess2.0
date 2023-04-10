package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.move.SearchMode;
import com.ab.chess.move.TileIterator;
import com.ab.chess.position.Position;
import java.util.*;

public class Pawn extends Piece {
  private static final Map<Color, Set<Integer>> STARTING_TILES =
      Map.of(
          Color.WHITE,
          Set.of(8, 9, 10, 11, 12, 13, 14, 15),
          Color.BLACK,
          Set.of(48, 49, 50, 51, 52, 53, 54, 55));

  private static final Map<Color, Direction> MOVE_DIRECTIONS =
      Map.of(Color.WHITE, Direction.UP, Color.BLACK, Direction.DOWN);

  private static final Map<Color, Set<Direction>> CAPTURE_DIRECTIONS =
      Map.of(
          Color.WHITE, Set.of(Direction.LEFT_UP, Direction.RIGHT_UP),
          Color.BLACK, Set.of(Direction.LEFT_DOWN, Direction.RIGHT_DOWN));

  public Pawn(Color color, int tileIndex) {
    super(color, tileIndex);
  }


  @Override
  public List<Integer> findPossibleMoves(Position position) {
    return findTiles(position, SearchMode.POSSIBLE_MOVES);
  }

  @Override
  public List<Integer> findControlledTiles(Position position) {
    return findTiles(position,  SearchMode.CONTROLLED_TILES);
  }
  // TODO: refactor to make it more readable

  private List<Integer> findTiles(Position position, SearchMode searchMode) {
    List<Integer> moves = new ArrayList<>();

    for (Direction direction : CAPTURE_DIRECTIONS.get(color)) {
      TileIterator captureIterator = new TileIterator(tileIndex, direction);
      if (captureIterator.hasNext()) {
        int currentTile = captureIterator.next();
        switch (searchMode) {
          case POSSIBLE_MOVES -> {
            if (position.tileOccupiedByEnemy(currentTile, color)) {
              moves.add(currentTile);
            }
          }
          case CONTROLLED_TILES -> {
            moves.add(currentTile);
          }
        }
      }
    }
    if(searchMode == SearchMode.POSSIBLE_MOVES){
      List<Integer> nonCapturingMoves = findNonCapturingMoves(position);
      moves.addAll(nonCapturingMoves);
    }
    return moves;
  }

  private List<Integer> findNonCapturingMoves(Position position) {
    List<Integer> moves = new ArrayList<>();
    TileIterator iterator = new TileIterator(tileIndex, getDirection());

    if (!iterator.hasNext()) {
      throw new IllegalStateException("Pawn reached last rank - it should be promoted before.");
    }
    int currentTile = iterator.next();

    if (!position.tileEmpty(currentTile)) {
      return moves;
    }
    moves.add(currentTile);

    if (!iterator.hasNext()) {
      return moves;
    }
    currentTile = iterator.next();
    if (STARTING_TILES.get(color).contains(tileIndex) && position.tileEmpty(currentTile)) {
      moves.add(currentTile);
    }
    return moves;
  }

  private Direction getDirection() {
    return MOVE_DIRECTIONS.get(color);
  }
}
