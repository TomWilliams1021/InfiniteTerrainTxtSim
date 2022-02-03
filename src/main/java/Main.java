import com.MapSquares.ForestMapSquare;
import com.MapSquares.HillMapSquare;
import com.MapSquares.MapSquare;
import com.MapSquares.MountainMapSquare;

public class Main {

    public static void main(String[] args){
        Map gameMap = createMap();

        gameMap.addMapSquare(new MountainMapSquare());
        gameMap.addMapSquare(new HillMapSquare());
        gameMap.addMapSquare(new ForestMapSquare());



        for (int i = 0; i < gameMap.MapSize(); i++) {
            MapSquare tstSquare = gameMap.getMapSquare(i);
            System.out.println(tstSquare.getSquareType());
        }

    }

    public static Map createMap(){
        return new Map();
    }
}
