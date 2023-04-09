package com.ab.chess.move;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TileIteratorTest {
  @Test
  void moveOneStep() {
    Direction direction = Direction.RIGHT_UP;
    TileIterator tileIterator = new TileIterator(9, direction);

    assertThat(tileIterator.next()).isEqualTo(18);
  }
}
