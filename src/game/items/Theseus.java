package game.items;

import engine.actions.ActionList;
import engine.actors.Actor;
import engine.items.Item;
import engine.positions.GameMap;
import engine.positions.Location;
import engine.positions.NumberRange;
import game.actions.TeleportAction;
import game.actions.TravelAction;
import game.maps.Travelable;
import game.utils.Utility;

import java.util.Random;

/**
 * Theseus class is a class that represents a Theseus item
 *
 * @author noahd
 * @version 1.0
 */
public class Theseus extends Item implements Purchasable, Teleportable {
    private static final int PRICE = 100;
    private boolean bIsError = false;

    /**
     * Constructor for the Theseus class
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    /**
     * List of allowable actions that can be performed on the Theseus when it is on the ground
     * @param location the location of the ground on which the item lies
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = new ActionList();

        int x = Utility.randomXCoordinate(location);
        int y = Utility.randomYCoordinate(location);

        actions.add(new TeleportAction(this, x, y));

        return actions;
    }

    /**
     * Method that allows an actor to purchase a Theseus
     * @param actor the actor that is attempting to purchase the item
     * @return boolean True indicating the purchase was successful
     */
    public boolean purchaseBy(Actor actor) {
        actor.deductBalance(PRICE);
        actor.addItemToInventory(this);
        return true;
    }

    /**
     * Getter that returns the price of the Theseus
     * @return Integer that represents the price
     */
    public int getPrice() {
        return PRICE;
    }

    /**
     * Method that determines if an error occurs
     * @return boolean
     */
    public boolean getIsError() {
        return this.bIsError;
    }

    /**
     * Method that returns an error message if purchase failed
     * @param actor the actor that is attempting to purchase the item and is getting an error in the transaction
     * @return String representing an error message
     */
    public String getErrorMessage(Actor actor) {
        return "No error message";
    }

    /**
     * Method that teleports the player to a random location upon using the Theseus
     * @param actor The actor being teleported
     * @param map The map the actor is currently in
     * @param x The x coordinate the actor will be teleported to
     * @param y The y coordinate the actor will be teleported to
     */
    public void teleport(Actor actor, GameMap map, int x, int y) {
        map.addActor(actor, map.at(x,y));
    }
}
