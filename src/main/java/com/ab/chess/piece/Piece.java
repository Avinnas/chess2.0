package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public abstract class Piece {
  
  protected final Color color;
  protected int tileIndex;

  public abstract List<Integer> findPossibleMoves(Position position);

  public abstract List<Integer> findControlledTiles(Position position);
  
  public List<Direction> getMoveDirections(){
    return new ArrayList<>();
  }

  public boolean isFriend(Color other){
    return color.isFriend(other);
  }
  
  public boolean isEnemy(Color other){
    return color.isEnemy(other);
  }
}
