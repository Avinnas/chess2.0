package com.ab.chess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ab.chess.move.Direction;
import com.ab.chess.move.TileIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TileIteratorTest {
  @ParameterizedTest
  @MethodSource("constructor_tileOutOfBounds_input")
  void constructor_tileOutOfBounds_throwsException(int tileIndex) {

    assertThatThrownBy(() -> new TileIterator(tileIndex, Direction.DOWN))
        .isInstanceOf(IllegalArgumentException.class);
  }

  static Stream<Integer> constructor_tileOutOfBounds_input() {
    return Stream.of(-1, 64);
  }

  @Test
  void hasNext_nextTileOutOfBounds_returnsFalse() {
    Direction direction = Direction.DOWN;
    TileIterator tileIterator = new TileIterator(0, direction);

    boolean actual = tileIterator.hasNext();

    assertThat(actual).isFalse();
  }

  @Test
  void hasNext_nextTileInBounds_returnsTrue() {
    Direction direction = Direction.DOWN;
    TileIterator tileIterator = new TileIterator(8, direction);

    boolean actual = tileIterator.hasNext();

    assertThat(actual).isTrue();
  }

  @Test
  void next_moveOneStep_returnsCorrectValue() {
    Direction direction = Direction.RIGHT_UP;
    TileIterator tileIterator = new TileIterator(9, direction);

    Integer actual = tileIterator.next();

    int expected = 18;
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void next_nextTileOutOfBounds_throwsNoSuchElementException() {
    Direction direction = Direction.DOWN;
    TileIterator tileIterator = new TileIterator(0, direction);

    assertThatThrownBy(tileIterator::next).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void next_moveToTheEndOfTheIterator_returnsCorrectValues() {
    Direction direction = Direction.RIGHT;
    TileIterator tileIterator = new TileIterator(0, direction);

    List<Integer> actual = new ArrayList<>();
    while (tileIterator.hasNext()) {
      actual.add(tileIterator.next());
    }

    List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
    assertThat(actual).isEqualTo(expected);
  }
}
