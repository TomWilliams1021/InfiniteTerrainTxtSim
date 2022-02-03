package com.Characters;
public class Player extends GenericCharacter{

    private int goldenCompass;

    public Player(){
        this.goldenCompass = 0;
        this.setCharacterX_Coord(0);
        this.setCharacterY_Coord(0);
    }

    public Player (String name){
        this.setCharacterName(name);
        this.goldenCompass = 0;
        this.setCharacterX_Coord(0);
        this.setCharacterY_Coord(0);
    }
}
