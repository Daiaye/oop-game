package game.plants;

import edu.monash.fit2099.engine.positions.Location;

public class YoungInheritree extends Inheritree{

    public static final int EVOLVE_AGE = 5;

    /**
     * A constructor of the YoungInheritree class
     */
    public YoungInheritree() {
        super('y');
    }



    @Override
    protected boolean shouldEvolve() {
        return getCounter() >= EVOLVE_AGE;
    }

    @Override
    protected void evolve(Location location) {
        location.setGround(new MatureInheritree());
    }

    @Override
    protected void produceFruit(Location location) {
        // does not produce fruit
    }
}
