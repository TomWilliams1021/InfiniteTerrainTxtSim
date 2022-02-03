import com.MapSquares.*;
import com.MainGameClasses.Game;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        boolean validNewGameString = false;

        while(validNewGameString != true){
            char newGameString = StartNewGame();

            if (newGameString == 'y'){
                Game newGame = new Game();
            } else if (newGameString == 'n'){
                return;
            }else{
                System.out.println("INVALID character entered, please try again.");
            }
        }

    }

    public static char StartNewGame(){
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Welcome to ???. To begin a new game please enter Y, to exit please enter N");
        String inputString = userInputScanner.nextLine();
        inputString.toLowerCase();
        char inputChar = inputString.charAt(0);
        System.out.println(inputChar);

        return inputChar;
    }

}
