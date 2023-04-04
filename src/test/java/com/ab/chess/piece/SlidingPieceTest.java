package com.ab.chess.piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;
import java.util.List;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class SlidingPieceTest {

  @ParameterizedTest(name = "{index}: {0} ")
  @MethodSource("findInDirectionEmptyBoard")
  void findInDirections_emptyBoard_returnsCorrectMoves(SlidingPieceTestData slidingPieceTestData) {
    SlidingPiece slidingPiece = mock(SlidingPiece.class, Mockito.CALLS_REAL_METHODS);
    Position position = new Position();
    slidingPiece.color = Color.BLACK;

    List<Integer> actual =
        slidingPiece.findInDirections(
            position, slidingPieceTestData.tileIndex, slidingPieceTestData.directions);

    List<Integer> expected = slidingPieceTestData.expected;
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> findInDirectionEmptyBoard() {
    return Stream.of(
        Arguments.of(
            Named.of(
                "Piece can't move",
                new SlidingPieceTestData(0, List.of(new Direction(-1, 0)), List.of()))),
        Arguments.of(
            Named.of(
                "Piece can move in straight line",
                new SlidingPieceTestData(
                    0, List.of(new Direction(1, 0)), List.of(1, 2, 3, 4, 5, 6, 7)))),
        Arguments.of(
            Named.of(
                "Piece can move in diagonal line",
                new SlidingPieceTestData(
                    36, List.of(new Direction(-1, -1)), List.of(27, 18, 9, 0)))),
        Arguments.of(
            Named.of(
                "Piece can move in multiple directions",
                new SlidingPieceTestData(
                    36,
                    List.of(new Direction(-1, -1), new Direction(1, 0)),
                    List.of(27, 18, 9, 0, 37, 38, 39)))));
  }

  @ParameterizedTest(name = "{index}: {0} ")
  @MethodSource("findInDirectionNonEmptyBoard")
  void findInDirections_nonEmptyBoard_returnsCorrectMoves(
      SlidingPieceTestData slidingPieceTestData) {
    SlidingPiece slidingPiece = mock(SlidingPiece.class, Mockito.CALLS_REAL_METHODS);
    slidingPiece.color = Color.BLACK;
    Position position = Position.createStartingPosition();

    List<Integer> actual =
        slidingPiece.findInDirections(
            position, slidingPieceTestData.tileIndex, slidingPieceTestData.directions);

    List<Integer> expected = slidingPieceTestData.expected;
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> findInDirectionNonEmptyBoard() {
    return Stream.of(
        Arguments.of(
            Named.of(
                "Piece stops when blocked",
                new SlidingPieceTestData(35, List.of(new Direction(0, 1)), List.of(43)))),
        Arguments.of(
            Named.of(
                "Piece stops after capturing enemy",
                new SlidingPieceTestData(35, List.of(new Direction(0, -1)), List.of(27,19, 11)))));
  }

  @AllArgsConstructor
  public static class SlidingPieceTestData {
    private int tileIndex;
    private List<Direction> directions;
    private List<Integer> expected;
  }
}
