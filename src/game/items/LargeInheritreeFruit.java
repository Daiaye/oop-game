package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.actions.ConsumeAction;
import game.actions.SellAction;

/**
 * LargeInheritreeFruit class is a class that represents a large Inheritree Fruit
 * It can be consumed to heal the actor who consumed it
 *
 * @author noahd, RichieC
 * @version 2.0
 */
public class LargeInheritreeFruit extends Item implements Consumable, Sellable {

    private static final int HEALING_AMOUNT = 2;
    private static final int CREDIT_VALUE = 30;

    /**
     * A constructor for the LargeInheritreeFruit class
     */
    public LargeInheritreeFruit() {
        super("large Inheritree fruit", 'O', true);
    }

    /**
     * Returns the list of actions that the LargeInheritreeFruit can perform to its owner
     * @param owner the actor that owns the LargeInheritreeFruit
     * @return ActionList that contains the actions that the LargeInheritreeFruit can perform to its owner
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public void consume(Actor actor) {
        actor.heal(HEALING_AMOUNT);
        actor.removeItemFromInventory(this);
    }

    @Override
    public String verb() {
        return "eats";
    }

    @Override
    public String effect() {
        return "heals " + HEALING_AMOUNT + " HP";
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
