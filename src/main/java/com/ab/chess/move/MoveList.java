package com.ab.chess.move;

import com.ab.chess.piece.Piece;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

public class MoveList {
  private final List<Integer> moves = new ArrayList<>();
  private final Position position;
  private final int pieceTile;
  private final Piece piece;

  public MoveList(Position position, int pieceTile, Piece piece) {
    this.position = position;
    this.pieceTile = pieceTile;
    this.piece = piece;
  }

  public void add(Integer tileIndex) {
    if (!position.tileOccupiedByFriend(tileIndex + pieceTile, piece.getColor())) {
      moves.add(tileIndex + pieceTile);
    }
  }

  public List<Integer> getMoves() {
    return moves;
  }
}
