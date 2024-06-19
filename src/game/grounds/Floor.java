package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.actors.Actor;
import game.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Floor extends Ground {
    /**
     * A constructor for the Floor class
     */
    public Floor() {
        super('_');
    }

    /**
     * Determines whether an actor can walk on a floor
     * @param actor the Actor to check
     * @return True if the actor can walk on the floor, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Ability.ACCESS_FLOOR)) {
            return true;
        }
        return false;
    }
}
