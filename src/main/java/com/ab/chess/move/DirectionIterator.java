package com.ab.chess.move;

import com.ab.chess.utils.TileHelper;

public class DirectionIterator {
  private final Direction direction;
  private int currentTile;

  public DirectionIterator(int startTile, Direction direction) {
    this.direction = direction;
    this.currentTile = startTile;
  }

  public int next() {
    return currentTile + direction.y() * 8 + direction.x();
  }

  public boolean hasNext() {
    int nextColumn = TileHelper.column(currentTile) + direction.x();
    int nextRow = TileHelper.row(currentTile) + direction.y();
    return inBounds(nextRow) && inBounds(nextColumn);

  }
  private boolean inBounds(int index){
    return index <= 7 && index >= 0;
  }
}
