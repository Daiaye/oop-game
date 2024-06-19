package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PurchaseAction;
import game.actions.TravelAction;
import game.items.Purchasable;
import game.maps.Travelable;

import java.util.ArrayList;
import java.util.List;

/**
 * ComputerTerminal class is a class that represents a computer terminal
 *
 * @author noahd
 * @version 1.0
 */
public class ComputerTerminal extends Ground {
    private List<Purchasable> itemsForSale = new ArrayList<>();
    private List<Travelable> destinations = new ArrayList<>();

    /**
     * A constructor for the ComputerTerminal class
     */
    public ComputerTerminal() {
        super('=');
    }

    /**
     * A method that adds a purchasable to the computer terminal
     * @param item The purchasable to be added
     */
    public void addToStock(Purchasable item) {
        itemsForSale.add(item);
    }

    /**
     * A method that adds a travelable to the computer terminal
     * @param map The travelable to be added
     */
    public void addTravelDestination(Travelable map) {
        destinations.add(map);
    }

    /**
     * List of allowable actions that can be performed on the computer terminal
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        for (Purchasable item : itemsForSale) {
            actions.add(new PurchaseAction(item));
        }

        for (Travelable destination : destinations) {
            if (destination != location.map()) {
                actions.add(new TravelAction(destination));
            }
        }

        return actions;
    }
}
