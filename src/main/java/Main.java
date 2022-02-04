import com.MainGameClasses.Game;
import com.MapSquares.MapSquare;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Game newGame;
        Scanner userInputScanner = new Scanner(System.in);
        boolean validNewGameString = false;

        while(!validNewGameString){
            char newGameString;
            boolean keepPlaying;
            //boolean keepPlayingInputValid = false;
            boolean movementInputValid = false;
            String inputString;

            System.out.println("Welcome to ???. To begin a new game please enter Y, to exit please enter N");
            inputString = userInputScanner.nextLine();
            newGameString = StartNewGame(inputString);

            if (newGameString == 'y'){
                validNewGameString = true;
                newGame = new Game();
                keepPlaying = true;

            }else if (newGameString == 'n'){
                break;
            }else{
                System.out.println("INVALID character entered, please try again.");
                continue;
            }

                while (keepPlaying) {

                    System.out.println("\r\n" + "\r\n" + "\r\n" + "\r\n"+ "\r\n");
                    newGame.LoadSquaresAroundPlayerIntoLocalAreaMap(newGame.getPlayer1());
                    newGame.DrawLocalMap();
                    System.out.println("\r");
                    newGame.CalculateTreasureDistance(newGame.getPlayer1());

                    System.out.println("Your Golden compass tells you the treasure is " + newGame.getPlayer1().getGoldenCompass() + "m away.");
                    if(newGame.getPlayer1().getGoldenCompass() == 0.0){
                        System.out.println("You've successfully found the treasure,\r\n CONGRATULATIONS!!!");
                        break;
                    }

                    while(!movementInputValid) {
                        System.out.println("Enter North / South / East / West to move in that direction.");
                        inputString = userInputScanner.nextLine();
                        movementInputValid = newGame.CheckMovementInputValid(inputString);
                    }

                    if(movementInputValid) {
                        newGame.getPlayer1().incrementX_YCoordinateBasedOnMove(newGame.getPlayer1().getMove());
                        movementInputValid = false;
                    }
                }


        }

    }

    public static char StartNewGame(String inputString){
        return inputString.toLowerCase().charAt(0);
    }
}
