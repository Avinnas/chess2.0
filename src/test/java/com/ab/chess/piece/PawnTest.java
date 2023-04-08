package com.ab.chess.piece;

import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

  @Test
  void findPossibleMoves() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = Position.createStartingPosition();
    List<Integer> actual = pawn.findPossibleMoves(position, 8);

    List<Integer> expected = List.of(16, 24);

    assertThat(actual).hasSameElementsAs(expected);
  }
}
