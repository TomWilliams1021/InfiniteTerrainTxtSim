package com.Characters;


public abstract class GenericCharacter {
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

    public void setMove(String move){
        movementDirection moveValue = movementDirection.valueOf(move);
        this.move = moveValue;
    }

    public movementDirection getMove()
    {
        return this.move;
    }

    public void incrementX_YCoordinateBasedOnMove(movementDirection move){
        switch(move){
            case North:
                this.setCharacterX_Coord(this.getCharacterX_Coord() - movementDirection.North.value);
                break;
            case South:
                this.setCharacterX_Coord(this.getCharacterX_Coord() - movementDirection.South.value);
                break;
            case East:
                this.setCharacterY_Coord(this.getCharacterY_Coord() - movementDirection.East.value);
                break;
            case West:
                this.setCharacterY_Coord(this.getCharacterY_Coord() - movementDirection.West.value);
                break;
            default:
                break;

        }
    }
}
