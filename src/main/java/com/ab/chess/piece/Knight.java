package com.ab.chess.piece;

import com.ab.chess.move.MoveList;
import com.ab.chess.position.Position;

import java.util.List;

import static com.ab.chess.utils.TileHelper.column;
import static com.ab.chess.utils.TileHelper.row;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    private void addIfNotOccupied(Position position, List<Integer> tiles, int tileIndex){
        if(!position.tileOccupiedBy(tileIndex, color)){
            tiles.add(tileIndex);
        }
    }

    @Override
    public List<Integer> findPossibleTilesToMove(Position position, int tileIndex) {

        MoveList moveList = new MoveList(position, tileIndex, this);

        if(row(tileIndex) < 7){
            if(column(tileIndex) < 6){
                moveList.add(10);
            }
            if(column(tileIndex) > 1){
                moveList.add(6);
            }
            if(row(tileIndex) < 6){
                if(column(tileIndex) < 7){
                    moveList.add(17);
                }
                if(column(tileIndex) > 0){
                    moveList.add(15);
                }
            }
        }
        if(row(tileIndex) > 0){
            if(column(tileIndex) < 6){
                moveList.add(-6);
            }
            if(column(tileIndex) > 1){
                moveList.add(-10);
            }
            if(row(tileIndex) > 1){
                if(column(tileIndex) < 7){
                    moveList.add(-15);
                }
                if(column(tileIndex) > 0){
                    moveList.add(-17);
                }
            }
        }

        return moveList.getMoves();
    }
}
