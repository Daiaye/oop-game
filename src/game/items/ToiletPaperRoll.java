package game.items;

import engine.actions.ActionList;
import engine.actors.Actor;
import engine.items.Item;
import engine.positions.GameMap;
import engine.positions.Location;
import game.Ability;
import game.actions.SellAction;

/**
 * ToiletPaperRoll class is a class that represents a toilet paper roll
 *
 * @author noahd, JakeK
 * @version 1.0
 */
public class ToiletPaperRoll extends Item implements Purchasable, Sellable {
    /**
     * A constructor for the ToiletPaperRoll class
     */
    private static final int PRICE = 5;
    private boolean bIsError = false;
    private final boolean KILL;
    private final static int CREDIT_VALUE = 1;
    private final static double KILL_UPON_SOLD_CHANCE = 0.5;

    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
        KILL = Math.random() <= KILL_UPON_SOLD_CHANCE;
    }

    @Override
    public boolean purchaseBy(Actor actor) {
        int payablePrice;
        if (actor.getBalance() > PRICE) {
            if (Math.random() < 0.75) {
                this.bIsError = true;
                payablePrice = PRICE / 5;
            } else {
                this.bIsError = false;
                payablePrice = PRICE;
            }
            actor.addItemToInventory(new ToiletPaperRoll());
            actor.deductBalance(payablePrice);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public boolean getIsError() {
        return this.bIsError;
    }

    @Override
    public String getErrorMessage(Actor actor) {
        if (purchaseBy(actor)) {
            return "The terminal malfunctioned! The item has been reduced to $" + PRICE / 5 + ", "+actor + " purchases " + this + " for " + PRICE / 5 + " credits";
        }
        else {
            int missingCredits = PRICE - actor.getBalance();
            return "The terminal malfunctioned! The item has been reduced to $" + PRICE / 5 + ", purchase failed! " + actor + " is missing " + missingCredits + " credits";
        }
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        if (otherActor.hasCapability(Ability.BE_SOLD_TO)) {
            return new ActionList(new SellAction(this));
        }
        return new ActionList();
    }

    @Override
    public void sell(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        if (KILL) {
            actor.unconscious(map);
        } else {
            actor.addBalance(CREDIT_VALUE);
        }
    }

    @Override
    public String outcome() {
        if (KILL) {
            return " dies a gruesome death by the hands of the Humanoid Figure!";
        } else {
            return " sells the " + this + " for " + CREDIT_VALUE + " credit";
        }
    }
}
