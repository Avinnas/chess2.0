package com.ab.chess.piece;

import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class QueenTest {

  @Test
  void findPossibleMoves_defaultStartingBoard_returnsCorrectMoves() {
    Queen queen = new Queen(Color.WHITE, 16);
    Position position = Position.createStartingPosition();
    position.putPiece(queen);

    List<Integer> actual = queen.findPossibleMoves(position);
    List<Integer> expected = List.of(25, 34, 43, 52, 24, 32, 40, 48, 17, 18, 19, 20, 21, 22, 23);

    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_defaultStartingBoard_returnsCorrectMoves() {
    Queen queen = new Queen(Color.WHITE, 16);
    Position position = Position.createStartingPosition();
    position.putPiece(queen);

    List<Integer> actual = queen.findControlledTiles(position);
    List<Integer> expected = List.of(25, 34, 43, 52, 24, 32, 40, 48, 17, 18, 19, 20, 21, 22, 23, 8, 9);

    assertThat(actual).hasSameElementsAs(expected);
  }
}
