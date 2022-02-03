package com.MapSquares;

import com.MapSquares.MapSquare;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Map {
    private ArrayList generatedMapSquares;
    private MapSquare[][] localAreaMap;

    public Map(){
        this.generatedMapSquares = new ArrayList<MapSquare>();
        this.localAreaMap = new MapSquare[3][3];
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

    public void setLocalAreaMap(int xPos, int yPos, MapSquare mapSquare){
        this.localAreaMap[xPos][yPos] = mapSquare;
    }

    public MapSquare getLocalAreaMapSquare(int xPos, int yPos){
        return this.localAreaMap[xPos][yPos];
    }

}
