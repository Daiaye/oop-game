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
 * JarOfPickles is a class that represents a jar of pickles
 * It can be consumed to heal or harm the player
 *
 * @author richieC
 * @version 1.0
 */
public class JarOfPickles extends Item implements Consumable, Sellable {

    public final boolean expired;
    public static final int HEALTH_MODIFIER = 1;
    private static final int CREDIT_VALUE = 25;
    private static final int INCREASED_CREDIT_VALUE = 50;
    private static final double EXPIRY_CHANCE = 0.5;

    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
        expired = Math.random() <= EXPIRY_CHANCE;
    }
    /**
     * Returns the list of actions that the JarOfPickles can perform to its owner
     * @param owner the actor that owns the JarOfPickles
     * @return ActionList that contains the actions that the JarOfPickles can perform to its owner
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public void consume(Actor actor) {
        if (expired) {
            actor.hurt(HEALTH_MODIFIER);
        } else {
            actor.heal(HEALTH_MODIFIER);
        }
        actor.removeItemFromInventory(this);
    }

    @Override
    public String verb() {
        return "eats";
    }

    @Override
    public String effect() {
        if (expired) {
            return "loses " + HEALTH_MODIFIER + " HP. It's expired, why would you eat that?";
        } else {
            return "heals " + HEALTH_MODIFIER + " HP. Huh, tasty.";
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

        // Reusing expired boolean as it is also 50% chance
        if (!expired) {
            actor.addBalance(INCREASED_CREDIT_VALUE);
        } else {
            actor.addBalance(CREDIT_VALUE);
        }
    }

    @Override
    public String outcome() {

        // Reusing expired boolean as it is also 50% chance
        if (!expired) {
            return " sells the " + this + " for " + INCREASED_CREDIT_VALUE + " credits! Those bartering skills are finally coming in handy.";
        } else {
            return " sells the " + this + " for " + CREDIT_VALUE + " credits";
        }
    }
}
