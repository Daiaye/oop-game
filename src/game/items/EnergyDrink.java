package game.items;

import engine.actions.ActionList;
import engine.actors.Actor;
import engine.items.Item;
import game.actions.ConsumeAction;
import game.grounds.ComputerTerminal;

/**
 * EnergyDrink is a class that represents an energy drink
 * It can be consumed to heal the player
 *
 * @author JakeK
 * @version 1.0
 */
public class EnergyDrink extends Item implements Purchasable, Consumable {
    private static final int PRICE = 10;
    private static final double DBL_PRICE_CHANCE = 0.2;
    private static final int HEALING_AMOUNT = 1;
    private boolean bIsError = false;

    public EnergyDrink() {
        super("Energy Drink", '*', true);
    }

    @Override
    public void consume(Actor actor) {
        actor.heal(HEALING_AMOUNT);
        actor.removeItemFromInventory(this);
    }
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }
    @Override
    public String verb() {
        return "chugs";
    }
    @Override
    public String effect() {
        return "heals " + HEALING_AMOUNT + " hp";
    }
    public boolean purchaseBy(Actor actor) {
        int payablePrice;
        if (actor.getBalance() >= PRICE) {
            if (Math.random() <= DBL_PRICE_CHANCE) {
                if (actor.getBalance() >=DBL_PRICE_CHANCE) {
                    this.bIsError = true;
                    payablePrice = 2*PRICE;
                }
                else {
                    return false;
                }
            } else {
                this.bIsError = false;
                payablePrice = PRICE;
            }
            actor.addItemToInventory(new EnergyDrink());
            actor.deductBalance(payablePrice);
            return true;
        } else {
            return false;
        }
    }
    public int getPrice() {
        return PRICE;
    }
    public boolean getIsError() {
        return this.bIsError;
    }
    public String getErrorMessage(Actor actor) {
        if (purchaseBy(actor)) {
            return "The terminal malfunctioned! The energy drink's price has been doubled to $"+PRICE*2 + ", "+actor + " purchases " + this + " for " + PRICE / 5 + " credits";
        }
        else {
            int missingCredits = PRICE - actor.getBalance();
            return "The terminal malfunctioned! The energy drink's price has been doubled to $"+PRICE*2 + ", purchase failed! " + actor + " is missing " + missingCredits + " credits";
        }
    }
}
