package game.plants;

import engine.positions.Location;
import game.items.SmallInheritreeFruit;

/**
 * InheritreeSapling class is a class that represents an Inheritree sapling
 *
 * @author noahd
 * @version 1.0
 */
public class InheritreeSapling extends Inheritree {

    public static final int EVOLVE_AGE = 6;

    public static final double PRODUCTION_CHANCE = 0.3;

    /**
     * A constructor of the InheritreeSapling class
     */
    public InheritreeSapling() {
        super('t');
    }


    @Override
    protected boolean shouldEvolve() {
        return getCounter() >= EVOLVE_AGE;
    }

    @Override
    protected void evolve(Location location) {
        location.setGround(new YoungInheritree());
    }

    @Override
    protected void produceFruit(Location location) {
        Location fruitDestination = tryToProduceFruit(location, PRODUCTION_CHANCE);
        if (fruitDestination != null) {
            fruitDestination.addItem(new SmallInheritreeFruit());
        }
    }
}
