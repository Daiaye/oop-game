package game.behaviours;

import engine.actors.Behaviour;
import engine.actions.Action;
import engine.actors.Actor;
import engine.positions.GameMap;
import engine.positions.Exit;
import engine.positions.Location;
import game.actors.attributes.Status;
import game.actions.AttackAction;

/**
 * AttackBehaviour class is a class that represents a behaviour to attack an actor
 * It implements the Behaviour interface
 *
 * @author noahd
 * @version 1.0
 */
public class AttackBehaviour implements Behaviour {
    /**
     * Returns an AttackAction to attack an actor
     * If there are no actors that are able to be attacked, returns null
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @ an Action, or null if no AttackAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                return new AttackAction(destination.getActor(), exit.getName());
            }
        }
        return null;
    }
}