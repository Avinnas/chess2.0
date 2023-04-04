package com.ab.chess.move;

import com.ab.chess.piece.Piece;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

public class MoveList {
  private final List<Integer> moves = new ArrayList<>();
  private final Position position;
  private final Piece piece;

  public MoveList(Position position,  Piece piece) {
    this.position = position;
    this.piece = piece;
  }

  public void add(Integer tileIndex) {
    if(position.tileOccupiedByFriend(tileIndex, piece.getColor())){
      return;
    }
      moves.add(tileIndex);
  }

  public List<Integer> getMoves() {
    return moves;
  }
}
