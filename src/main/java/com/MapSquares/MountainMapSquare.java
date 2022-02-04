package com.MapSquares;

public class MountainMapSquare extends MapSquare {
    private String squareTypeString = "Mountain";
    private String[][] squareArt = new String[][]{{"", "", "", "/", "\\", "", "", ""},
                                                    {"", "", "/", "/", "\\", "\\", "", ""},
                                                    {"", "/", "", "", "", "", "\\", ""},
                                                    {"/", "", "", "", "", "", "", "\\"}};
    public MountainMapSquare(){
        this.setSquareType(squareTypeString);
        this.setSquareArt(squareArt);
    }

}
