package com.ab.chess.piece;

import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KingTest {

  @Test
  public void findPossibleMoves_emptyBoard_returnsCorrectMoves() {
    King king = new King(Color.WHITE);
    Position position = new Position();
    position.putPiece(35, king);

    List<Integer> actual = king.findPossibleMoves(position, 35);

    List<Integer> expected = List.of(34, 36, 27, 26, 28, 43, 42, 44);
    assertThat(actual).hasSameElementsAs(expected);
  }

    @Test
    public void findPossibleMoves_canCaptureEnemyAndIsBlockedByFriend_returnsCorrectMoves() {
        King king = new King(Color.WHITE);
        Position position = new Position();
        Piece friend = new Pawn(Color.WHITE);
        Piece enemy = new Pawn(Color.BLACK);
        position.putPiece(35, king);
        position.putPiece(34, friend);
        position.putPiece(36, enemy);

        List<Integer> actual = king.findPossibleMoves(position, 35);

        List<Integer> expected = List.of(36, 27, 26, 28, 43, 42, 44);
        assertThat(actual).hasSameElementsAs(expected);
    }

    @Test
    public void findControlledTiles_canCaptureEnemyAndIsBlockedByFriend_returnsCorrectMoves() {
        King king = new King(Color.WHITE);
        Position position = new Position();
        Piece friend = new Pawn(Color.WHITE);
        Piece enemy = new Pawn(Color.BLACK);
        position.putPiece(35, king);
        position.putPiece(34, friend);
        position.putPiece(36, enemy);

        List<Integer> actual = king.findControlledTiles(position, 35);

        List<Integer> expected = List.of(34, 36, 27, 26, 28, 43, 42, 44);
        assertThat(actual).hasSameElementsAs(expected);
    }
}
