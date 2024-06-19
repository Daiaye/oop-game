package game.items;

import engine.actions.ActionList;
import engine.actors.Actor;
import engine.items.Item;
import engine.positions.GameMap;
import engine.positions.Location;
import game.Ability;
import game.actions.ConsumeAction;
import game.actions.SellAction;

/**
 * PotOfGold is a class that represents a pot of gold
 * It can be consumed to add 10 credits to the player
 *
 * @author richieC
 * @version 1.0
 */
public class PotOfGold extends Item implements Consumable, Sellable {

    public static final int GOLD_AMOUNT = 10;
    public final boolean stolen;
    public static final int CREDIT_VALUE = 500;
    public static final double STOLEN_RATE = 0.25;

    public PotOfGold() {
        super("Pot of Gold", '$', true);
        stolen = Math.random() <= STOLEN_RATE;
    }
    /**
     * Returns the list of actions that the PotOfGold can perform to its owner
     * @param owner the actor that owns the PotOfGold
     * @return ActionList that contains the actions that the PotOfGold can perform to its owner
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public void consume(Actor actor) {
        actor.addBalance(GOLD_AMOUNT);
        actor.removeItemFromInventory(this);
    }

    @Override
    public String verb() {
        return "opens";
    }

    @Override
    public String effect() {
        return "gains " + GOLD_AMOUNT + " credits! All for the company *sigh*.";
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
        if (!stolen) {
            actor.addBalance(CREDIT_VALUE);
        }
    }

    @Override
    public String outcome() {
        if (stolen) {
            return " has their " + this + " stolen! All for the company *sigh*";
        } else {
            return " sells the " + this + " for " + CREDIT_VALUE + " credits";
        }
    }
}
