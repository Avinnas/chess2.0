package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.move.TileIterator;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;import java.util.Set;

public class Pawn extends Piece {
  private static final Map<Color, Set<Integer>> STARTING_TILES =
      Map.of(
          Color.WHITE,
          Set.of(8, 9, 10, 11, 12, 13, 14, 15),
          Color.BLACK,
          Set.of(48, 49, 50, 51, 52, 53, 54, 55));

  private static final Map<Color, Direction> MOVE_DIRECTIONS =
      Map.of(Color.WHITE, Direction.UP, Color.BLACK, Direction.DOWN);

  public Pawn(Color color) {
    super(color);
  }

  @Override
  public List<Integer> findPossibleMoves(Position position, int pieceTileIndex) {
    TileIterator iterator = new TileIterator(pieceTileIndex, getDirection());
    List<Integer> moves = new ArrayList<>();

    if (!iterator.hasNext()) {
      return moves;
    }
    int currentTile = iterator.next();

    if (position.tileEmpty(currentTile)) {
      moves.add(currentTile);
    }

    if(!iterator.hasNext()){
      return moves;
    }
    currentTile = iterator.next();
    if(STARTING_TILES.get(color).contains(pieceTileIndex) && position.tileEmpty(currentTile)){
      moves.add(currentTile);
    }
    return moves;
  }

  @Override
  public List<Integer> findControlledTiles(Position position, int pieceTileIndex) {
    return null;
  }

  private Direction getDirection() {
    return MOVE_DIRECTIONS.get(color);
  }
}
