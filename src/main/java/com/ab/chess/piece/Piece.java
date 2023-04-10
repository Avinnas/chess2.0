package com.ab.chess.piece;

import com.ab.chess.position.Position;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Piece {
  protected final Color color;
  protected int tileIndex;

  public abstract List<Integer> findPossibleMoves(Position position);

  public abstract List<Integer> findControlledTiles(Position position);
}
