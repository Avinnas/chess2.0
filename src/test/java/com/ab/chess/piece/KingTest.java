package com.ab.chess.piece;

import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KingTest {

  @Test
  public void findPossibleMoves_emptyBoard_returnsCorrectMoves() {
    King king = new King(Color.WHITE, 35);
    Position position = new Position();
    position.putPiece(king);

    List<Integer> actual = king.findPossibleMoves(position);

    List<Integer> expected = List.of(34, 36, 27, 26, 28, 43, 42, 44);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  public void findPossibleMoves_canCaptureEnemyAndIsBlockedByFriend_returnsCorrectMoves() {
    King king = new King(Color.WHITE, 35);
    Position position = new Position();
    Piece friend = new Pawn(Color.WHITE, 34);
    Piece enemy = new Pawn(Color.BLACK, 36);
    position.putPiece(king);
    position.putPiece(friend);
    position.putPiece(enemy);

    List<Integer> actual = king.findPossibleMoves(position);

    List<Integer> expected = List.of(36, 27, 26, 28, 43, 42, 44);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  public void findControlledTiles_canCaptureEnemyAndIsBlockedByFriend_returnsCorrectMoves() {
    King king = new King(Color.WHITE, 35);
    Position position = new Position();
    Piece friend = new Pawn(Color.WHITE, 34);
    Piece enemy = new Pawn(Color.BLACK, 36);
    position.putPiece(king);
    position.putPiece(friend);
    position.putPiece(enemy);

    List<Integer> actual = king.findControlledTiles(position);

    List<Integer> expected = List.of(34, 36, 27, 26, 28, 43, 42, 44);
    assertThat(actual).hasSameElementsAs(expected);
  }
}
