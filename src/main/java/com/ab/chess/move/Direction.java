package com.ab.chess.move;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

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

  public static final List<Direction> STRAIGHT_AND_DIAGONAL =
      List.of(UP, DOWN, LEFT, RIGHT, LEFT_UP, RIGHT_UP, LEFT_DOWN, RIGHT_DOWN);

  public static final List<Direction> STRAIGHT = List.of(UP, DOWN, LEFT, RIGHT);

  public static final List<Direction> DIAGONAL = List.of(LEFT_UP, RIGHT_UP, LEFT_DOWN, RIGHT_DOWN);

  public Direction opposite() {

    // THROW ?
    return Arrays.stream(values())
        .filter(value -> value.x == x && value.y == -y)
        .findFirst()
        .get();
  }
}
