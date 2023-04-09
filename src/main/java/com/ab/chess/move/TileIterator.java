package com.ab.chess.move;

import com.ab.chess.utils.TileHelper;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TileIterator implements Iterator<Integer> {
  private final Direction direction;
  private int currentTile;

  public TileIterator(int startTile, Direction direction) {
    this.direction = direction;
    this.currentTile = startTile;
    if (!currentTileInBounds()) {
      throw new IllegalArgumentException(String.format("Tile: %s is out of bounds", startTile));
    }
  }

  public Integer next() {
    currentTile += direction.getY() * 8 + direction.getX();
    if (!currentTileInBounds()) {
      throw new NoSuchElementException(
          String.format("Next element in this direction: %s is out of bounds", direction));
    }
    return currentTile;
  }

  private boolean currentTileInBounds() {
    return currentTile >= 0 && currentTile <= 63;
  }

  public boolean hasNext() {
    int nextColumn = TileHelper.column(currentTile) + direction.getX();
    int nextRow = TileHelper.row(currentTile) + direction.getY();
    return columnRowInBounds(nextRow) && columnRowInBounds(nextColumn);
  }

  private boolean columnRowInBounds(int index) {
    return index <= 7 && index >= 0;
  }
}
