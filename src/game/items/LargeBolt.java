package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.actions.SellAction;

/**
 * LargeBolt class is a class that represents a large bolt
 *
 * @author noahd
 * @version 1.0
 */
public class LargeBolt extends Item implements Sellable {

    private final static int CREDIT_VALUE = 25;

    /**
     * A constructor for the LargeBolt class
     */
    public LargeBolt() {
        super("large bolt", '+', true);
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
        actor.addBalance(CREDIT_VALUE);
    }

    @Override
    public String outcome() {return " sells the " + this + " for " + CREDIT_VALUE + " credits";}
}
