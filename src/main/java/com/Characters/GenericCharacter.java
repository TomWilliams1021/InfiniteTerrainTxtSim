package com.Characters;

enum movementDirection {
    North,
    South,
    East,
    West
}

public class GenericCharacter {
    private String characterName;
    private int characterX_Coord;
    private int characterY_Coord;
    private movementDirection move;

    public GenericCharacter() {
        this.characterName = "Default Name";
        this.move = null;
    }

    public void setCharacterName(String inputName){
        this.characterName = inputName;
    }

    public String getCharacterName(){
        return this.characterName;
    }

    public void setCharacterX_Coord(int x_coord){
        this.characterX_Coord = x_coord;
    }

    public int getCharacterX_Coord(){
        return this.characterX_Coord;
    }

    public void setCharacterY_Coord(int y_coord){
        this.characterY_Coord = y_coord;
    }

    public int getCharacterY_Coord(){
        return this.characterY_Coord;
    }

    public void setMove(movementDirection move){
        this.move = move;
    }

    public movementDirection getMove()
    {
        return move;
    }
}
