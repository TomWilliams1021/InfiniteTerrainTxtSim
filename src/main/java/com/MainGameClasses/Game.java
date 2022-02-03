package com.MainGameClasses;

import com.MapSquares.*;
import com.MapSquares.Map;

public class Game {
    private Map gameMap = createMap();

    public Game(){

        gameMap.addMapSquare(new MountainMapSquare());
        gameMap.addMapSquare(new HillMapSquare());
        gameMap.addMapSquare(new ForestMapSquare());

        for (int i = 0; i < gameMap.MapSize(); i++) {
            MapSquare tstSquare = gameMap.getMapSquare(i);
            System.out.println(tstSquare.getSquareType());
        }


    }

    public static Map createMap(){
        return new Map();
    }
}
