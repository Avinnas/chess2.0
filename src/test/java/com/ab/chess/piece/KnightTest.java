package com.ab.chess.piece;

import com.ab.chess.position.Position;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {

  @ParameterizedTest(name = "{index}: {0} ")
  @MethodSource("arguments")
  void findPossibleMoves_emptyBoard_returnsCorrectMoves(KnightTestData knightTestData) {
    Position position = new Position();
    Knight knight = new Knight(Color.WHITE, knightTestData.input);
    position.putPiece(knight);
    List<Integer> moves = knight.findPossibleMoves(position);

    assertThat(moves).hasSameElementsAs(knightTestData.output);
  }

  static Stream<Arguments> arguments() {
    return Stream.of(
        Arguments.of(
            Named.named("Knight in left down corner", new KnightTestData(0, List.of(10, 17)))),
        Arguments.of(
            Named.named("Knight in right down corner", new KnightTestData(7, List.of(13, 22)))),
        Arguments.of(
            Named.named("Knight in left up corner", new KnightTestData(56, List.of(41, 50)))),
        Arguments.of(
            Named.named("Knight in right up corner", new KnightTestData(63, List.of(53, 46)))),
        Arguments.of(
            Named.named("Knight at 0th row", new KnightTestData(3, List.of(9, 18, 20, 13)))),
        Arguments.of(
            Named.named("Knight at 7th row", new KnightTestData(60, List.of(54, 45, 43, 50)))),
        Arguments.of(
            Named.named("Knight at 0th column", new KnightTestData(24, List.of(9, 18, 34, 41)))),
        Arguments.of(
            Named.named("Knight at 7th column", new KnightTestData(39, List.of(22, 29, 45, 54)))),
        Arguments.of(
            Named.named(
                "Knight at 1th row", new KnightTestData(12, List.of(2, 18, 27, 29, 22, 6)))),
        Arguments.of(
            Named.named(
                "Knight at 6th row", new KnightTestData(52, List.of(58, 42, 35, 37, 46, 62)))),
        Arguments.of(
            Named.named(
                "Knight at 1th column", new KnightTestData(25, List.of(8, 10, 19, 35, 40, 42)))),
        Arguments.of(
            Named.named(
                "Knight at 6th column", new KnightTestData(38, List.of(23, 21, 28, 44, 53, 55)))),
        Arguments.of(
            Named.named(
                "Knight in the center",
                new KnightTestData(28, List.of(11, 18, 13, 22, 38, 45, 43, 34)))));
  }

  @Test
  void findPossibleMoves_defaultStartingBoard_knightCanCaptureEnemy() {
    Position position = Position.createStartingPosition();
    Knight knight = new Knight(Color.WHITE, 43);
    position.putPiece(knight);

    List<Integer> moves = knight.findPossibleMoves(position);

    List<Integer> expected = List.of(49, 58, 60, 53, 33, 26, 28, 37);
    assertThat(moves).hasSameElementsAs(expected);
  }

  @Test
  void findPossibleMoves_defaultStartingBoard_knightCannotCaptureFriend() {
    Position position = Position.createStartingPosition();
    Knight knight = new Knight(Color.BLACK, 43);
    position.putPiece(knight);

    List<Integer> moves = knight.findPossibleMoves(position);

    List<Integer> expected = List.of(33, 26, 28, 37);
    assertThat(moves).hasSameElementsAs(expected);
  }

  @Test
  void findControlledTiles_defaultStartingBoard_knightControlsTilesOccupiedByFriend() {
    Position position = Position.createStartingPosition();
    Knight knight = new Knight(Color.BLACK, 43);
    position.putPiece(knight);

    List<Integer> moves = knight.findControlledTiles(position);

    List<Integer> expected = List.of(49, 58, 60, 53, 33, 26, 28, 37);
    assertThat(moves).hasSameElementsAs(expected);
  }

  @AllArgsConstructor
  public static class KnightTestData {
    private int input;
    private List<Integer> output;
  }
}
