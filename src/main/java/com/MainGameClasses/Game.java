package com.MainGameClasses;

import com.MapSquares.*;
import com.MapSquares.Map;
import com.Characters.Player;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Map gameMap;
    private Player player1;

    public Game(){
        gameMap = new Map();
        player1 = newPlayerNameCheckAndSet();

        Random random = new Random();
        int randNumForTreasureXCoord = random.nextInt(25 - 5) + 5;
        int randNumForTreasureYCoord = random.nextInt(25 - 5) + 5;
        MapSquare thisSquare = generateTreasureMapSquare(randNumForTreasureXCoord, randNumForTreasureYCoord);
        gameMap.addMapSquare(thisSquare);
    }

    public Player newPlayerNameCheckAndSet(){
        System.out.println("Time to create your character, Please enter their name.");
        Scanner userInputScanner = new Scanner(System.in);
        String playerNameString = userInputScanner.nextLine();
        return new Player(playerNameString);
    }

    public void LoadSquaresAroundPlayerIntoLocalAreaMap(Player player){
        int currentX_Coord = player.getCharacterX_Coord();
        int currentY_Coord = player.getCharacterY_Coord();

        for (int i = 0; i < 9; i++) {
            MapSquare squareExists = null;
            int thisSquareX_Coord = 0;
            int thisSquareY_Coord = 0;
            MapSquare thisSquare;

            switch(i){
                case 0:
                    squareExists = searchExistingMapSquares(currentX_Coord,currentY_Coord);
                    thisSquareX_Coord = currentX_Coord;
                    thisSquareY_Coord = currentY_Coord;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    //Add thisSquare into correct position in localAreaMap.
                    break;
                case 1:
                    squareExists = searchExistingMapSquares((currentX_Coord + 1),currentY_Coord);
                    thisSquareX_Coord = currentX_Coord + 1;
                    thisSquareY_Coord = currentY_Coord;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                case 2:
                    squareExists = searchExistingMapSquares(currentX_Coord,(currentY_Coord + 1));
                    thisSquareX_Coord = currentX_Coord;
                    thisSquareY_Coord = currentY_Coord + 1;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                case 3:
                    squareExists = searchExistingMapSquares((currentX_Coord - 1),currentY_Coord);
                    thisSquareX_Coord = currentX_Coord - 1;
                    thisSquareY_Coord = currentY_Coord;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                case 4:
                    squareExists = searchExistingMapSquares(currentX_Coord,(currentY_Coord - 1));
                    thisSquareX_Coord = currentX_Coord;
                    thisSquareY_Coord = currentY_Coord - 1;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                case 5:
                    squareExists = searchExistingMapSquares((currentX_Coord + 1),(currentY_Coord + 1));
                    thisSquareX_Coord = currentX_Coord + 1;
                    thisSquareY_Coord = currentY_Coord + 1;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                case 6:
                    squareExists = searchExistingMapSquares((currentX_Coord - 1),(currentY_Coord - 1));
                    thisSquareX_Coord = currentX_Coord - 1;
                    thisSquareY_Coord = currentY_Coord - 1;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                    case 7:
                    squareExists = searchExistingMapSquares((currentX_Coord + 1),(currentY_Coord - 1));
                    thisSquareX_Coord = currentX_Coord + 1;
                    thisSquareY_Coord = currentY_Coord - 1;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                case 8:
                    squareExists = searchExistingMapSquares((currentX_Coord - 1),(currentY_Coord + 1));
                    thisSquareX_Coord = currentX_Coord - 1;
                    thisSquareY_Coord = currentY_Coord + 1;
                    thisSquare = setSquareValue(squareExists, thisSquareX_Coord, thisSquareY_Coord, player);
                    addMapSquareToLocalAreaMap(thisSquare, player);
                    break;
                default:
                    break;
            }
        }
    }

    public MapSquare searchExistingMapSquares(int x_coord, int y_coord){
        for (int i = 0; i < gameMap.MapSize(); i++) {
            MapSquare currentMapSquare = gameMap.getMapSquare(i);
            if(currentMapSquare.getX_coord() == x_coord && currentMapSquare.getY_Coord() == y_coord){
                return currentMapSquare;
            }
        }
        return null;
    }

    public MapSquare generateNewMapSquare(int x_coord, int y_coord){
        Random randNum = new Random();
        int randNumResult = randNum.nextInt(4);

        MapSquare newMapSquare = new MountainMapSquare();

        switch(randNumResult){
            case 1:
                newMapSquare = new PlainsMapSquare();
                break;
            case 2:
                newMapSquare = new HillMapSquare();
                break;
            case 3:
                newMapSquare = new ForestMapSquare();
            case 4:
                //Will give a mountain map square as this is the default.
                break;
        }

        newMapSquare.setX_Coord(x_coord);
        newMapSquare.setY_Coord(y_coord);

        return newMapSquare;
    }

    public MapSquare generateTreasureMapSquare(int x_coord, int y_coord){
        MapSquare treasureMapSquare = new TreasureMapSquare();
        treasureMapSquare.setX_Coord(x_coord);
        treasureMapSquare.setY_Coord(y_coord);
        return treasureMapSquare;
    }

    public MapSquare setSquareValue(MapSquare squareExists, int x_coord, int y_coord, Player player){
        MapSquare thisSquare;

        if(squareExists == null){
            thisSquare = generateNewMapSquare(x_coord, y_coord);
            gameMap.addMapSquare(thisSquare);
        }else{
            thisSquare = squareExists;
        }

        return thisSquare;
    }

    public void addMapSquareToLocalAreaMap(MapSquare squareToAdd, Player player){
        //take the coordinates of the square being added(x,y),
        // compare them to the players coordinates(x,y) and place the square in the
        // corresponding position in the LocalAreaMap array (player is always in the centre).
        int localMapX;
        int localMapY;
        if(squareToAdd.getX_coord() < player.getCharacterX_Coord()){
            localMapX = 0;
        }else if(squareToAdd.getX_coord() == player.getCharacterX_Coord()){
            localMapX = 1;
        }else {
            localMapX = 2;
        }

        if(squareToAdd.getY_Coord() < player.getCharacterY_Coord()){
            localMapY = 2;
        }else if (squareToAdd.getY_Coord() == player.getCharacterY_Coord()){
            localMapY = 1;
        }else{
            localMapY = 0;
        }

        gameMap.setLocalAreaMap(localMapX, localMapY, squareToAdd);

    }

    public void DrawLocalMap(){
        String[][] MapStrings = new String[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                MapStrings[x][y] = (gameMap.getLocalAreaMapSquare(x,y).getSquareType());
            }
        }

        System.out.println(MapStrings[0][0] + " | " + MapStrings[0][1] + " | " + MapStrings[0][2]);
        System.out.println(MapStrings[1][0] + " | " + MapStrings[1][1] + " | " + MapStrings[1][2]);
        System.out.println(MapStrings[2][0] + " | " + MapStrings[2][1] + " | " + MapStrings[2][2]);

    }

    public boolean CheckMovementInputValid(String inputString){
        boolean movementInputValid = false;
        switch (inputString) {
            case "North":
                player1.setMove("North");
                movementInputValid = true;
                break;
            case "South":
                player1.setMove("South");
                movementInputValid = true;
                break;
            case "East":
                player1.setMove("East");
                movementInputValid = true;
                break;
            case "West":
                player1.setMove("West");
                movementInputValid = true;
                break;
            default:
                System.out.println("The direction input was invalid.");
                break;
        }
        return movementInputValid;
    }

    public Player getPlayer1(){
        return player1;
    }

    public void CalculateTreasureDistance(Player player){
        MapSquare treasure = gameMap.getMapSquare(0);
        int treasureX = treasure.getX_coord();
        int treasureY = treasure.getY_Coord();
        int playerX = player.getCharacterX_Coord();
        int playerY = player.getCharacterY_Coord();
        int xDistance;
        int yDistance;

        if(treasureX < 0 || playerX < 0){
            //If either or both coordinates are negative, make them both positive and add together
            // to find the total difference between them.
            treasureX = Math.abs(treasureX);
            playerX = Math.abs(playerX);
            xDistance = treasureX + playerX;
        }else if(treasureX > playerX){
            xDistance = treasureX - playerX;
        }else{
            xDistance = playerX - treasureX;
        }

        if(treasureY < 0 || playerY < 0){
            //If either or both coordinates are negative, make them both positive and add together
            // to find the total difference between them.
            treasureY = Math.abs(treasureY);
            playerY = Math.abs(playerY);
            yDistance = treasureY + playerY;
        }else if(treasureY > playerY){
            yDistance = treasureY - playerY;
        }else{
            yDistance = playerY - treasureY;
        }

        double distance = Math.sqrt((xDistance*xDistance)+(yDistance*yDistance));
        player.setGoldenCompass(distance);
    }

    public void asciiArtDrawTest(){
        gameMap.addMapSquare(generateNewMapSquare(0,0));
        System.out.println(gameMap.getMapSquare(1).getSquareArt().toString());
    }
}
