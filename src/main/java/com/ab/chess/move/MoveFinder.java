package com.ab.chess.move;

import com.ab.chess.piece.Color;
import com.ab.chess.piece.King;
import com.ab.chess.piece.Piece;
import com.ab.chess.position.Position;

import java.util.*;
import java.util.stream.Collectors;

public class MoveFinder {
  public List<Move> findLegalMoves(Position position) {
    return findPseudoLegalMoves(position);
  }

  public List<Move> findPseudoLegalMoves(Position position) {
    return null;
  }

  public List<Piece> findPinnedPieces(Position position) {
    List<Piece> pinnedPieces = new ArrayList<>();

    // TODO: PINNED PIECES INCLUDE PINNING DIRECTION
    for (Direction direction : Direction.STRAIGHT_AND_DIAGONAL) {
      Piece encounteredFriend = null;
      Color color = position.getMovingColor();
      King king = position.getKing(color);
      TileIterator iterator = new TileIterator(king.getTileIndex(), direction);
      while (iterator.hasNext()) {
        int currentTile = iterator.next();
        if (position.tileOccupiedByEnemy(currentTile, king.getColor())) {
          // Sprawdzanie szachowania tutaj?
          if (encounteredFriend != null) {
            Piece piece = position.getPiece(currentTile);
            List<Direction> pieceDirections = piece.getMoveDirections();
            if (pieceDirections.contains(direction.opposite())) {
              pinnedPieces.add(piece);
            }
          }
        } else if (position.tileOccupiedByFriend(currentTile, king.getColor())) {
          encounteredFriend = position.getPiece(currentTile);
        }
      }
    }
    return pinnedPieces;
  }



  public List<Piece> getCheckingPieces(King checkedKing){
    Map<Piece, List<Integer>> moves = new HashMap<>();
    int tile = checkedKing.getTileIndex();


    return moves.entrySet().stream()
            .filter(entry -> entry.getValue().contains(tile))
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
  }
}
