package game.plants;

import engine.positions.Ground;
import engine.positions.Location;
import game.utils.Utility;

/**
 * Inheritree class is a class that represents an Inheritree which is a type of tree
 * It extends the Ground class as it occupies a space on the game map
 *
 * @author noahd
 * @version 1.0
 */
public abstract class Inheritree extends Ground {
    private int counter;

    /**
     * A constructor of the Inheritree class
     * @param displayChar The character to represent the Inheritree on the game map
     */
    public Inheritree(char displayChar) {
        super(displayChar);
        this.counter = 0;
    }

    /**
     * Inheritree experiences the passing of time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        counter += 1;
        if (shouldEvolve()) {
            evolve(location);
        }
        produceFruit(location);
    }

    /**
     * Returns the number of ticks since the creation of an Inheritree
     * @return The age of the Inheritree as an integer
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Determines if the Inheritree should evolve to the next stage
     * @return True if the Inheritree should evolve, false otherwise
     */
    protected abstract boolean shouldEvolve();

    /**
     * Evolves the Inheritree to the next stage
     * @param location The location of the current Inheritree
     */
    protected abstract void evolve(Location location);

    /**
     * Produces fruit based on the specific Inheritree's logic
     * @param location The location of the current Inheritree
     */
    protected abstract void produceFruit(Location location);

    /**
     * Attempts to produce a fruit at one of the available exits of this Inheritree based on a given chance of production
     * @param location The current location of the Inheritree
     * @param productionChance The chance of producing a fruit
     * @return The location where the fruit will appear on the map if it is successfully produced, null otherwise
     */
    public Location tryToProduceFruit(Location location, double productionChance) {
        if (Math.random() <= productionChance) {
            Location fruitDestination = Utility.chooseRandomDestination(location);
            return fruitDestination;
        }
        return null;
    }
}
