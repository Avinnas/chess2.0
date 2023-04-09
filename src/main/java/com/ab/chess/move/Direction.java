package com.ab.chess.move;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
  UP(0, 1),
  DOWN(0, -1),
  LEFT(-1, 0),
  RIGHT(1, 0),
  LEFT_UP(-1, 1),
  RIGHT_UP(1, 1),
  LEFT_DOWN(-1, -1),
  RIGHT_DOWN(1, -1),
  L_SHAPE_UP_LEFT(-1, 2),
  L_SHAPE_UP_RIGHT(1, 2),
  L_SHAPE_DOWN_LEFT(-1, -2),
  L_SHAPE_DOWN_RIGHT(1, -2),
  L_SHAPE_LEFT_UP(-2, 1),
  L_SHAPE_LEFT_DOWN(-2, -1),
  L_SHAPE_RIGHT_UP(2, 1),
  L_SHAPE_RIGHT_DOWN(2, -1);

  private final int x;
  private final int y;
}
