package com.ab.chess.move;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void moveOneStep() {
        Direction direction = new Direction(1, 1);
        assertThat(direction.moveOneStep()).isEqualTo(9);
    }
}