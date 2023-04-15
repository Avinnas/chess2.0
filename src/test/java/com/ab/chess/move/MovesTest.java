package com.ab.chess.move;

import static org.assertj.core.api.Assertions.assertThat;

import com.ab.chess.piece.Color;
import com.ab.chess.piece.Knight;
import com.ab.chess.piece.Piece;
import com.ab.chess.position.Position;
import java.util.List;
import org.junit.jupiter.api.Test;

class MovesTest {

  @Test
  void getCheckingPieces() {
    Moves moves = new Moves();
    Knight knight = new Knight(Color.BLACK, 19);
    Position position = Position.createStartingPosition();
    position.putPiece(knight);

    // TODO : refactor - use Moves class
    List<Integer> knightMoves = knight.findPossibleMoves(position);
    knightMoves.forEach(move -> moves.add(knight, move));

    List<Piece> actual = moves.getCheckingPieces(position.getKing(Color.WHITE));

    List<Piece> expected = List.of(knight);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void checkHandling(){
    Position position = Position.createStartingPosition();
    position.setMovingColor(Color.BLACK);
    Knight knight = new Knight(Color.BLACK, 19);
    position.putPiece(knight);
    Moves moves = position.findAllMoves();
    
    moves.handleCheck(position);

    System.out.println();
  }
}
