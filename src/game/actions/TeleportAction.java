package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Teleportable;

/**
 * TeleportAction class is a class that represents the action of teleporting
 *
 * @author noahd
 * @version 1.0
 */
public class TeleportAction extends Action {
    private Teleportable teleportable;
    private int x;
    private int y;

    /**
     * Constructor for the TeleportAction class
     * @param teleportable The teleportable that the player interacts with to teleport
     * @param x The x coordinate the player will be teleported to
     * @param y The y coordinate the player will be teleported to
     */
    public TeleportAction(Teleportable teleportable, int x, int y) {
        this.teleportable = teleportable;
        this.x = x;
        this.y = y;
    }

    /**
     * Executes the action of teleporting
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String that represents a description of the result of the action performed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!map.at(x,y).containsAnActor()) {
            map.removeActor(actor);
            teleportable.teleport(actor, map, x, y);
            return actor + " teleports to (" + x + "," + y + ") using " + teleportable;
        } else {
            return "Teleportation failed! Something is blocking the destination...";
        }
    }

    /**
     * A description of the teleport option that is displayed in the menu
     * @param actor The actor performing the action.
     * @return String that represents a description of this action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports using " + teleportable;
    }
}
