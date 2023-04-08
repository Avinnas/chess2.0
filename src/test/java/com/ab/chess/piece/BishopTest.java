package com.ab.chess.piece;

import static org.assertj.core.api.Assertions.assertThat;

import com.ab.chess.position.Position;
import java.util.List;
import org.junit.jupiter.api.Test;

class BishopTest {

  @Test
  void findPossibleMoves_defaultStartingBoard_returnsCorrectMoves() {
    Bishop bishop = new Bishop(Color.WHITE);
    Position position = Position.createStartingPosition();
    position.putPiece(16, bishop);

    List<Integer> actual = bishop.findPossibleMoves(position, 16);
    List<Integer> expected = List.of(25, 34, 43, 52);

    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_defaultStartingBoard_returnsCorrectMoves() {
    Bishop bishop = new Bishop(Color.WHITE);
    Position position = Position.createStartingPosition();
    position.putPiece(16, bishop);

    List<Integer> actual = bishop.findControlledTiles(position, 16);
    List<Integer> expected = List.of(9, 25, 34, 43, 52);

    assertThat(actual).hasSameElementsAs(expected);
  }
}
