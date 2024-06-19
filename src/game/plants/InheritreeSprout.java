package game.plants;

import edu.monash.fit2099.engine.positions.Location;

public class InheritreeSprout extends Inheritree {

    private static final int EVOLVE_AGE = 3; // connascence

    /**
     * A constructor of the InheritreeSprout class
     */
    public InheritreeSprout() {
        super(',');
    }

    @Override
    protected boolean shouldEvolve() {
        return getCounter() >= EVOLVE_AGE;
    }

    @Override
    protected void evolve(Location location) {
        location.setGround(new InheritreeSapling());
    }

    @Override
    protected void produceFruit(Location location) {
        // does not product fruit
    }
}
