package game.items;

import engine.actions.ActionList;
import engine.actors.Actor;
import game.actions.ConsumeAction;
import engine.items.Item;

/**
 * SmallInheritreeFruit class is a class that represents a small Inheritree Fruit
 * It can be consumed to heal the actor who consumed it
 *
 * @author noahd, RichieC
 * @version 2.0
 */
public class SmallInheritreeFruit extends Item implements Consumable {

    public static final int HEALING_AMOUNT = 1;

    /**
     * A constructor for the SmallInheritreeFruit class
     */
    public SmallInheritreeFruit() {
        super("small Inheritree fruit", 'o', true);
    }

    /**
     * Returns the list of actions that the SmallInheritreeFruit can perform to its owner
     * @param owner the actor that owns the SmallInheritreeFruit
     * @return ActionList that contains the actions that the SmallInheritreeFruit can perform to its owner
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
}
