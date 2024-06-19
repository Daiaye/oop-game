package game.plants;

import edu.monash.fit2099.engine.positions.Location;
import game.items.LargeInheritreeFruit;

/**
 * MatureInheritree class is a class that represents a mature Inheritree
 *
 * @author noahd
 * @version 1.0
 */
public class MatureInheritree extends Inheritree {

    public static final double PRODUCTION_CHANCE = 0.2;
    /**
     * A constructor of the MatureInheritree class
     */
    public MatureInheritree() {
        super('T');
    }

    @Override
    protected boolean shouldEvolve() {
        return false;
    }

    @Override
    protected void evolve(Location location) {
        // MatureInheritree does not evolve
    }

    @Override
    protected void produceFruit(Location location) {
        Location fruitDestination = tryToProduceFruit(location, PRODUCTION_CHANCE);
        if (fruitDestination != null) {
            fruitDestination.addItem(new LargeInheritreeFruit());
        }
    }
}
