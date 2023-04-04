package com.ab.chess.move;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Move {
  private final int startTile;
  private final int finishTile;
}
