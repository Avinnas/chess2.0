package com.ab.chess.piece;

import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {

    @Test
    void findPossibleTilesToMove1_LeftDownCorner() {
        Position position = new Position();
        Knight knight = new Knight(Color.WHITE);
        position.putPiece(0, knight);
        List<Integer> moves = knight.findPossibleTilesToMove(position, 0);

        assertThat(moves).hasSameElementsAs(List.of(10, 17));
    }

    @Test
    void findPossibleTilesToMove2_rightDownCorner() {
        Position position = new Position();
        Knight knight = new Knight(Color.WHITE);
        position.putPiece(7, knight);
        List<Integer> moves = knight.findPossibleTilesToMove(position, 7);

        assertThat(moves).hasSameElementsAs(List.of(13, 22));
    }

    @Test
    void findPossibleTilesToMove_leftUpCorner() {
        Position position = new Position();
        Knight knight = new Knight(Color.WHITE);
        position.putPiece(56, knight);
        List<Integer> moves = knight.findPossibleTilesToMove(position, 56);

        assertThat(moves).hasSameElementsAs(List.of(41, 50));
    }

    @Test
    void findPossibleTilesToMove4_rightUpCorner() {
        Position position = new Position();
        Knight knight = new Knight(Color.WHITE);
        position.putPiece(63, knight);
        List<Integer> moves = knight.findPossibleTilesToMove(position, 63);

        assertThat(moves).hasSameElementsAs(List.of(53, 46));
    }
}