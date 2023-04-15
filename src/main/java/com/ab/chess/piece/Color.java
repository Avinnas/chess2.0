package com.ab.chess.piece;

public enum Color {
  WHITE,
  BLACK;

  public boolean isFriend(Color color){
    return color == this;
  }

  public boolean isEnemy(Color color){
    return !isFriend(color);
  }
}
