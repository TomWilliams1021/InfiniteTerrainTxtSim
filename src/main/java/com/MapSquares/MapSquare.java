package com.MapSquares;

public abstract class MapSquare {
    private int x_coord;
    private int y_coord;
    private String squareType;
    private String[][] squareArt;

    public MapSquare(){
        this.x_coord = 0;
        this.y_coord = 0;
        this.squareType = "none";
    }

    public void setX_Coord(int x_coord){
        this.x_coord = x_coord;
    }

    public int getX_coord(){
        return x_coord;
    }

    public void setY_Coord(int y_coord){
        this.y_coord = y_coord;
    }

    public int getY_Coord(){
        return this.y_coord;
    }

    public String setSquareType(String squareType) {
        this.squareType = squareType;
        return this.squareType;
    }

    public String getSquareType(){
        return this.squareType;
    }

    public String[][] getSquareArt(){
        return squareArt;
    }

    public void setSquareArt(String[][] squareArt) {
        this.squareArt = squareArt;
    }
}
