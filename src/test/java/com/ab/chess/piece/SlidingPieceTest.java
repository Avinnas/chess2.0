package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class SlidingPieceTest {

    @Test
    void findInDirections() {
        SlidingPiece slidingPiece = mock(SlidingPiece.class, Mockito.CALLS_REAL_METHODS);
        var actual = slidingPiece.findInDirections(new Position(), 10, List.of(new Direction(1, 1), new Direction(0, 1)));
        List<Integer> expected = List.of(19, 28, 37, 46, 55, 18, 26, 34, 42, 50, 58);
        assertThat(actual).isEqualTo(expected);
    }
}