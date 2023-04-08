package com.ab.chess.piece;

import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RookTest {
  @Test
  void findPossibleMoves_defaultStartingBoard_returnsCorrectMoves() {
    Rook rook = new Rook(Color.WHITE);
    Position position = Position.createStartingPosition();
    position.putPiece(16, rook);

    List<Integer> actual = rook.findPossibleMoves(position, 16);
    List<Integer> expected = List.of(24, 32, 40, 48, 17, 18, 19, 20, 21, 22, 23);

    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_defaultStartingBoard_returnsCorrectMoves() {
    Rook rook = new Rook(Color.WHITE);
    Position position = Position.createStartingPosition();
    position.putPiece(16, rook);

    List<Integer> actual = rook.findControlledTiles(position, 16);
    List<Integer> expected = List.of(24, 32, 40, 48, 17, 18, 19, 20, 21, 22, 23, 8);

    assertThat(actual).hasSameElementsAs(expected);
  }
}
