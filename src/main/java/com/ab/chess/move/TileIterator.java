package com.ab.chess.move;

import com.ab.chess.utils.TileHelper;

public class TileIterator {
  private final Direction direction;
  private int currentTile;

  public TileIterator(int startTile, Direction direction) {
    this.direction = direction;
    this.currentTile = startTile;
  }

  public int next() {
    currentTile += direction.y() * 8 + direction.x();
    return currentTile;
  }

  public boolean hasNext() {
    int nextColumn = TileHelper.column(currentTile) + direction.x();
    int nextRow = TileHelper.row(currentTile) + direction.y();
    return inBounds(nextRow) && inBounds(nextColumn);
  }

  private boolean inBounds(int index) {
    return index <= 7 && index >= 0;
  }
}