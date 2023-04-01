package com.ab.chess.piece;

import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {

    @Test
    void findPossibleTilesToMove() {
        Position position = new Position();
        Knight knight = new Knight(Color.WHITE);
        position.putPiece(0, knight);
        List<Integer> moves = knight.findPossibleTilesToMove(position, 0);

        assertThat(moves).isEqualTo(List.of(10, 17));
    }
}