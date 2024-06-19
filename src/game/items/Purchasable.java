package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Purchasable interface is a class that classifies an item that can be "purchased"
 *
 * @author JakeK
 * @version 1.0
 */
public interface Purchasable {

    /**
     * A function that returns a boolean based off of whether the player can purchase the item
     * @param actor the actor that is attempting to purchase the item
     * @return boolean, e.g. true, false
     */
    public boolean purchaseBy(Actor actor);

    /**
     * returns the price of the purchasable item
     *
     * @return int, e.g. 10, 100
     */
    public int getPrice();

    /**
     * Returns a boolean to know whether the terminal had an error to affect the purchasing process
     *
     * @return boolean, e.g. true, false
     */
    public boolean getIsError();

    /**
     * Returns a string specific to the instance of how the error affected aspects such as price
     *
     * @param actor the actor that is attempting to purchase the item and is getting an error in the transaction
     * @return String, e.g. "You got scammed! " + PRICE + " credits were taken but you didn't receive the dragon slayer sword!"
     */
    public String getErrorMessage(Actor actor);
}
