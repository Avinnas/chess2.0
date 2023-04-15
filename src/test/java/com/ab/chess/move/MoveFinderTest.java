package com.ab.chess.move;

import com.ab.chess.piece.Color;
import com.ab.chess.piece.Pawn;
import com.ab.chess.piece.Piece;
import com.ab.chess.piece.Queen;
import com.ab.chess.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveFinderTest {

  @Test
  void findPinnedPieces() {
    MoveFinder moveFinder = new MoveFinder();

    Position position = Position.createStartingPosition();
    Piece piece = new Queen(Color.BLACK, 28);
    position.putPiece(piece);

    List<Piece> pinnedPieces = moveFinder.findPinnedPieces(position);

    List<Piece> expected = List.of(new Pawn(Color.WHITE, 12));

    assertThat(pinnedPieces).isEqualTo(expected);
  }
}
