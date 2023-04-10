package com.ab.chess.piece;

import static org.assertj.core.api.Assertions.assertThat;

import com.ab.chess.position.Position;
import java.util.List;
import org.junit.jupiter.api.Test;

class PawnTest {

  @Test
  void findPossibleMoves_pawnOnStartingPosition_returnsStartingMoves() {
    Pawn pawn = new Pawn(Color.WHITE, 8);
    Position position = new Position();
    List<Integer> actual = pawn.findPossibleMoves(position);

    List<Integer> expected = List.of(16, 24);
    assertThat(actual).hasSameElementsAs(expected);
  }
  @Test
  void findPossibleMoves_pawnNotOnStartingPosition_returnsOneMove() {
    Pawn pawn = new Pawn(Color.WHITE, 16);
    Position position = new Position();
    List<Integer> actual = pawn.findPossibleMoves(position);

    List<Integer> expected = List.of(24);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findPossibleMoves_pawnOnStartingPositionAndBlocked_returnsEmptyMoveList() {
    Pawn pawn = new Pawn(Color.WHITE, 8);
    Position position = Position.createStartingPosition();
    Pawn enemy = new Pawn(Color.BLACK, 16);
    position.putPiece(enemy);

    List<Integer> actual = pawn.findPossibleMoves(position);

    List<Integer> expected = List.of();
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findPossibleMoves_pawnOnStartingPositionAndSecondTileBlocked_returnsEmptyMoveList() {
    Pawn pawn = new Pawn(Color.WHITE, 8);
    Position position = Position.createStartingPosition();
    Pawn enemy = new Pawn(Color.BLACK, 24);
    position.putPiece(enemy);

    List<Integer> actual = pawn.findPossibleMoves(position);

    List<Integer> expected = List.of(16);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findPossibleMoves_enemyOnControlledTile_canCaptureEnemy() {
    Pawn pawn = new Pawn(Color.WHITE, 8);
    Position position = Position.createStartingPosition();
    Pawn enemy = new Pawn(Color.BLACK, 17);
    position.putPiece(enemy);
    
    List<Integer> actual = pawn.findPossibleMoves(position);

    List<Integer> expected = List.of(16, 24, 17);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_emptyControlledTiles_returnsControlledTiles() {
    Pawn pawn = new Pawn(Color.WHITE, 9);
    Position position = new Position();
    List<Integer> actual = pawn.findControlledTiles(position);

    List<Integer> expected = List.of(16, 18);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_tileOccupiedByFriend_returnsControlledTiles() {
    Pawn pawn = new Pawn(Color.WHITE, 9);
    Position position = new Position();
    Pawn friend1 = new Pawn(Color.WHITE, 16);
    Pawn friend2 = new Pawn(Color.WHITE, 18);
    position.putPiece(friend1);
    position.putPiece(friend2);
    
    List<Integer> actual = pawn.findControlledTiles(position);

    List<Integer> expected = List.of(16, 18);
    assertThat(actual).hasSameElementsAs(expected);
  }
  @Test
  void findControlledTiles_tileOccupiedByEnemy_returnsControlledTiles() {
    Pawn pawn = new Pawn(Color.WHITE, 9);
    Position position = new Position();
    Pawn enemy1 = new Pawn(Color.BLACK, 16);
    Pawn enemy2 = new Pawn(Color.BLACK, 18);
    position.putPiece(enemy1);
    position.putPiece(enemy2);

    List<Integer> actual = pawn.findControlledTiles(position);

    List<Integer> expected = List.of(16, 18);
    assertThat(actual).hasSameElementsAs(expected);
  }
}
