package com.ab.chess.move;

import com.ab.chess.piece.King;
import com.ab.chess.piece.Piece;
import com.ab.chess.position.Position;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Moves {
  private Map<Piece, List<Integer>> moves = new HashMap<>();

  public void add(Piece movingPiece, int tileIndex) {
    moves.computeIfAbsent(movingPiece, k -> new ArrayList<>()).add(tileIndex);
  }

  public void add(Piece movingPiece, List<Integer> moveList) {
    moves.put(movingPiece, moveList);
  }

  public List<Piece> getCheckingPieces(King checkedKing) {
    int tile = checkedKing.getTileIndex();

    return moves.entrySet().stream()
        .filter(entry -> entry.getValue().contains(tile))
        .map(entry -> entry.getKey())
        .collect(Collectors.toList());
  }

  public void handleCheck(Position position) {

    List<Piece> checkingPieces = getCheckingPieces(position.getCurrentKing());

    switch (checkingPieces.size()) {
      case 0 -> {}
      case 1 -> {
        Piece piece = checkingPieces.get(0);

        // removing all non-capture moves - refactor to work properly
        // TODO: Change this - controlled tiles (not possible moves) need to contain king
        moves =
            moves.entrySet().stream()
                .filter(entry -> entry.getValue().contains(piece.getTileIndex()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        if (piece.isBlockable()) {

          // TODO : find blocking moves

        }
      }
      default -> {
        moves =
            moves.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof King)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
      }
    }
  }
}
