package com.ab.chess.piece;

import com.ab.chess.position.Position;

import java.util.ArrayList;
import java.util.List;

import static com.ab.chess.utils.TileHelper.column;
import static com.ab.chess.utils.TileHelper.row;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public List<Integer> findPossibleTilesToMove(Position position, int tileIndex) {

        List<Integer> tileIndexes = new ArrayList<>();

        if(row(tileIndex) < 7){
            if(column(tileIndex) < 6){
                tileIndexes.add(10);
            }
            if(column(tileIndex) > 1){
                tileIndexes.add(6);
            }
            if(row(tileIndex) < 6){
                if(column(tileIndex) < 7){
                    tileIndexes.add(17);
                }
                if(column(tileIndex) > 0){
                    tileIndexes.add(15);
                }
            }
        }
        if(row(tileIndex) > 0){
            if(column(tileIndex) < 6){
                tileIndexes.add(-6);
            }
            if(column(tileIndex) > 1){
                tileIndexes.add(-10);
            }
            if(row(tileIndex) > 1){
                if(column(tileIndex) < 7){
                    tileIndexes.add(-15);
                }
                if(column(tileIndex) > 0){
                    tileIndexes.add(-17);
                }
            }
        }

        return tileIndexes;
    }
}
