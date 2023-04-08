package com.ab.chess.move;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TileIteratorTest {
    @Test
    void moveOneStep() {
        Direction direction = new Direction(1, 1);
    TileIterator tileIterator = new TileIterator(9, direction);

    assertThat(tileIterator.next()).isEqualTo(18);
    }
}