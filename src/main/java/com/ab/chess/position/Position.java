package com.ab.chess.position;

import com.ab.chess.move.Moves;
import com.ab.chess.piece.*;
import java.util.HashMap;
import java.util.Map;

public class Position {
  private Map<Integer, Piece> pieces = new HashMap<>();
  private Map<Color, King> k = new HashMap<>();

  // TODO: Update
  private Color movingColor = Color.WHITE;

  // remove, replace with builder ??
  public void setMovingColor(Color color) {
    movingColor = color;
  }

  public King getKing(Color color) {
    return (King)
        pieces.values().stream()
            .filter(piece -> piece instanceof King && piece.getColor() == color)
            .toList()
            .stream()
            .findFirst()
            .get();
  }

  public Color getMovingColor() {
    return movingColor;
  }

  public Position() {}

  private Position(Map<Integer, Piece> pieces) {
    this.pieces = pieces;
  }

  public static Position createStartingPosition() {
    Map<Integer, Piece> pieces = new HashMap<>();
    Map<Color, King> kings = new HashMap<>();
    pieces.put(0, new Rook(Color.WHITE, 0));
    pieces.put(1, new Knight(Color.WHITE, 1));
    pieces.put(2, new Bishop(Color.WHITE, 2));
    pieces.put(3, new Queen(Color.WHITE, 3));
    King whiteKing = new King(Color.WHITE, 4);
    pieces.put(4, whiteKing);

    kings.put(Color.WHITE, whiteKing);

    pieces.put(5, new Bishop(Color.WHITE, 5));
    pieces.put(6, new Knight(Color.WHITE, 6));
    pieces.put(7, new Rook(Color.WHITE, 7));

    for (int i = 8; i < 16; i++) {
      pieces.put(i, new Pawn(Color.WHITE, i));
    }

    for (int i = 48; i < 56; i++) {
      pieces.put(i, new Pawn(Color.BLACK, i));
    }

    pieces.put(56, new Rook(Color.BLACK, 56));
    pieces.put(57, new Knight(Color.BLACK, 57));
    pieces.put(58, new Bishop(Color.BLACK, 58));
    pieces.put(59, new Queen(Color.BLACK, 59));

    King blackKing = new King(Color.WHITE, 60);
    pieces.put(60, blackKing);
    kings.put(Color.WHITE, blackKing);

    pieces.put(61, new Bishop(Color.BLACK, 61));
    pieces.put(62, new Knight(Color.BLACK, 62));
    pieces.put(63, new Rook(Color.BLACK, 63));

    return new Position(pieces);
  }

  public King getCurrentKing(){
    return getKing(movingColor);
  }

  public boolean tileOccupiedByFriend(int tileIndex, Color color) {
    Piece piece = pieces.get(tileIndex);
    if (piece == null) {
      return false;
    }
    return piece.isFriend(color);
  }

  public boolean tileOccupiedByEnemy(int tileIndex, Color color) {
    Piece piece = pieces.get(tileIndex);
    if (piece == null) {
      return false;
    }
    return piece.isEnemy(color);
  }

  public Piece getPiece(int tileIndex) {
    // TODO: throw when no piece?
    return pieces.get(tileIndex);
  }

  public boolean tileEmpty(int tileIndex) {
    return pieces.get(tileIndex) == null;
  }

  public void putPiece(Piece piece) {
    pieces.put(piece.getTileIndex(), piece);
  }

  public Moves findAllMoves() {
    Moves moves = new Moves();
    pieces.values().stream()
        .filter(piece -> piece.isFriend(movingColor))
        // REFACTOR
        .forEach(piece -> moves.add(piece, piece.findPossibleMoves(this)));
    return moves;
  }
}
