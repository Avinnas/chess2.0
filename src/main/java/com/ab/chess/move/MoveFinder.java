package com.ab.chess.move;

import com.ab.chess.piece.Color;
import com.ab.chess.piece.King;
import com.ab.chess.piece.Piece;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

public class MoveFinder {
  public List<Move> findLegalMoves(Position position) {
    return findPseudoLegalMoves(position);
  }

  public List<Move> findPseudoLegalMoves(Position position) {
    return null;
  }

  public List<Piece> findPinnedPieces(Position position){
    List<Direction> moveDirections = Direction.STRAIGHT_AND_DIAGONAL;
    List<Piece> pinnedPieces = new ArrayList<>();



    // TODO: PINNED PIECES INCLUDE PINNING DIRECTION
    for (Direction direction : moveDirections){
      Piece encounteredFriend = null;
      Color color = position.getNextColor();
      King king = position.getKing(color);
      TileIterator iterator = new TileIterator(king.getTileIndex(), direction);
      while(iterator.hasNext()){
        int currentTile = iterator.next();
        if(position.tileOccupiedByEnemy(currentTile, king.getColor())){
          // Sprawdzanie szachowania tutaj?
          if(encounteredFriend != null){
            Piece piece = position.getPiece(currentTile);
            List<Direction> pieceDirections = piece.getMoveDirections();
            // Replace with contains? (FOR SURE) XD
            Piece finalEncounteredFriend = encounteredFriend;
            pieceDirections.stream()
                    .filter(pieceDirection -> Direction.oppositeOf(pieceDirection).equals(direction))
                    .findFirst()
                    .ifPresent((pieceDirection) -> pinnedPieces.add(finalEncounteredFriend));
          }
        } else if(position.tileOccupiedByFriend(currentTile, king.getColor())){
          encounteredFriend = position.getPiece(currentTile);
        }

      }

    }
    return pinnedPieces;
  }
}
