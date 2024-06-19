package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Wall class is a class that represents a wall
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {

    /**
     * A constructor for the Wall class
     */
    public Wall() {
        super('#');
    }

    /**
     * Determines whether an actor can walk on a wall
     * @param actor the Actor to check
     * @return False
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
