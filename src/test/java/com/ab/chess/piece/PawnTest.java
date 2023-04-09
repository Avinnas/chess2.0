package com.ab.chess.piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.ab.chess.position.Position;
import java.util.List;
import org.junit.jupiter.api.Test;

class PawnTest {

  @Test
  void findPossibleMoves_pawnOnStartingPosition_returnsStartingMoves() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = new Position();
    List<Integer> actual = pawn.findPossibleMoves(position, 8);

    List<Integer> expected = List.of(16, 24);
    assertThat(actual).hasSameElementsAs(expected);
  }
  @Test
  void findPossibleMoves_pawnNotOnStartingPosition_returnsOneMove() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = new Position();
    List<Integer> actual = pawn.findPossibleMoves(position, 16);

    List<Integer> expected = List.of(24);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findPossibleMoves_pawnOnStartingPositionAndBlocked_returnsEmptyMoveList() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = Position.createStartingPosition();
    Pawn enemy = new Pawn(Color.BLACK);
    position.putPiece(16, enemy);

    List<Integer> actual = pawn.findPossibleMoves(position, 8);

    List<Integer> expected = List.of();
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findPossibleMoves_pawnOnStartingPositionAndSecondTileBlocked_returnsEmptyMoveList() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = Position.createStartingPosition();
    Pawn enemy = new Pawn(Color.BLACK);
    position.putPiece(24, enemy);

    List<Integer> actual = pawn.findPossibleMoves(position, 8);

    List<Integer> expected = List.of(16);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findPossibleMoves_enemyOnControlledTile_canCaptureEnemy() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = Position.createStartingPosition();
    Pawn enemy = new Pawn(Color.BLACK);
    position.putPiece(17, enemy);
    
    List<Integer> actual = pawn.findPossibleMoves(position, 8);

    List<Integer> expected = List.of(16, 24, 17);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_emptyControlledTiles_returnsControlledTiles() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = new Position();
    List<Integer> actual = pawn.findControlledTiles(position, 9);

    List<Integer> expected = List.of(16, 18);
    assertThat(actual).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_tileOccupiedByFriend_returnsControlledTiles() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = new Position();
    Pawn friend1 = new Pawn(Color.WHITE);
    Pawn friend2 = new Pawn(Color.WHITE);
    position.putPiece(16, friend1);
    position.putPiece(18, friend2);
    
    List<Integer> actual = pawn.findControlledTiles(position, 9);

    List<Integer> expected = List.of(16, 18);
    assertThat(actual).hasSameElementsAs(expected);
  }
  @Test
  void findControlledTiles_tileOccupiedByEnemy_returnsControlledTiles() {
    Pawn pawn = new Pawn(Color.WHITE);
    Position position = new Position();
    Pawn enemy1 = new Pawn(Color.BLACK);
    Pawn enemy2 = new Pawn(Color.BLACK);
    position.putPiece(16, enemy1);
    position.putPiece(18, enemy2);

    List<Integer> actual = pawn.findControlledTiles(position, 9);

    List<Integer> expected = List.of(16, 18);
    assertThat(actual).hasSameElementsAs(expected);
  }
}
