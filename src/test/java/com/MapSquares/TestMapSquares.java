package com.MapSquares;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMapSquares {

    @Test
    public void testSetMapSquareXCoord(){
        MapSquare testSquare = new MountainMapSquare();
        testSquare.setX_Coord(1);
        assertEquals(1, testSquare.getX_coord(), "The set x coordinate method for map tile did not return the expected result.");
    }

    @Test
    public void testMapSquareSetType(){
        MapSquare testSquare = new MountainMapSquare();
        assertEquals("Mountain", testSquare.getSquareType(), "The set Map Tile SquareType method did not set the tile to be the expected tile type.");
    }
    
}
