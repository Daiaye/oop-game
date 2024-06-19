package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.maps.Travelable;

/**
 * TravelAction class is a class that represents the action of travelling
 *
 * @author noahd
 * @version 1.0
 */
public class TravelAction extends Action {
    private Travelable destination;

    /**
     * Constructor for the TravelAction class
     * @param destination The destination of the travel
     */
    public TravelAction(Travelable destination) {
        this.destination = destination;
    }

    /**
     * Executes the action of travelling
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String that represents a description of the result of the action performed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        destination.travel(actor);
        return actor + " arrived at " + destination;
    }

    /**
     * A description of the travel option that is displayed in the menu
     * @param actor The actor performing the action.
     * @return String that represents a description of this action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + destination;
    }
}
