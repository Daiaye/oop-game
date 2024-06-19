package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.actions.SellAction;

/**
 * MetalSheet class is a class that represents a metal sheet
 *
 * @author noahd
 * @version 1.0
 */
public class MetalSheet extends Item implements Sellable {

    private final static int CREDIT_VALUE = 20;
    private final static int DISCOUNTED_VALUE = 10;
    public final boolean discounted;
    public final static double RIPPED_OFF_CHANCE = 0.6;

    /**
     * A constructor for the MetalSheet class
     */
    public MetalSheet() {
        super("metal sheet", '%', true);
        discounted = Math.random() <= RIPPED_OFF_CHANCE;
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
        if (discounted) {
            actor.addBalance(DISCOUNTED_VALUE);
        } else {
            actor.addBalance(CREDIT_VALUE);
        }
    }

    @Override
    public String outcome() {
        if (discounted) {
            return " gets ripped off and sells the " + this + " for " + DISCOUNTED_VALUE + " credits";
        } else {
            return " sells the " + this + " for " + CREDIT_VALUE + " credits";
        }
    }
}
