package game.utils;

import engine.positions.Location;
import engine.positions.Exit;

import java.util.Random;
import java.util.List;

/**
 * Utility class is a class that contains methods for common game functionality
 *
 * @author noahd
 * @verion 1.0
 */
public class Utility {

    private static final Random random = new Random();
    /**
     * Chooses a random destination from the available exits of a given location
     * @param location The starting location
     * @return The destination location randomly selected from the available exits of a location
     */
    public static Location chooseRandomDestination(Location location) {
        List<Exit> exits = location.getExits();
        int index = random.nextInt(exits.size());
        Exit randomExit = exits.get(index);
        Location destination = randomExit.getDestination();
        return destination;
    }

    public static String randomThreeDigitID() {
        int randInt = random.nextInt(900) + 100;
        return String.valueOf(randInt);
    }

    public static int randomXCoordinate(Location location) {
        int xMax = location.map().getXRange().max() + 1;
        int randX = random.nextInt(xMax);
        return randX;
    }
    public static int randomYCoordinate(Location location) {
        int yMax = location.map().getYRange().max() + 1;
        int randY = random.nextInt(yMax);
        return randY;
    }

    //test
}
