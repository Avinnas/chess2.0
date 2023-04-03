package com.ab.chess.piece;

import com.ab.chess.move.Direction;
import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class SlidingPiece extends Piece{
    public SlidingPiece(Color color) {
        super(color);
    }

    public List<Integer> findInDirections(Position position, int startIndex, List<Direction> directions) {
        List<Integer> moves = new ArrayList<>();
        for(Direction direction : directions){
            moves.addAll(findInDirection(position, startIndex, direction));
        }
        return moves;
    }
    public List<Integer> findInDirection(Position position, int startIndex, Direction direction) {
        int currentIndex = startIndex;
        List<Integer> moves = new ArrayList<>();

        while(!position.tileOccupiedBy(currentIndex, color) && direction.isStepPossible(currentIndex)){
            currentIndex = direction.moveOneStep(currentIndex);
            moves.add(currentIndex);
            if(position.tileOccupiedBy(currentIndex, color)){
                break;
            }
        }
        return moves;
    }

}
