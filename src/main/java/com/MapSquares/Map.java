package com.MapSquares;

import com.MapSquares.MapSquare;

import java.util.ArrayList;

public class Map {
    private ArrayList generatedMapSquares;

    public Map(){
        this.generatedMapSquares = new ArrayList<MapSquare>();
    }

    public void addMapSquare(MapSquare newMapSquare){
        this.generatedMapSquares.add(newMapSquare);
    }

    public MapSquare getMapSquare(int index){
        MapSquare retreivedMapSquare = (MapSquare) this.generatedMapSquares.get(index);
        return retreivedMapSquare;
    }

    public int MapSize(){
        return this.generatedMapSquares.size();
    }

}
