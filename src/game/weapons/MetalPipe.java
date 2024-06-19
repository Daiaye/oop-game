package game.weapons;

import engine.positions.GameMap;
import engine.weapons.WeaponItem;
import engine.actors.Actor;
import engine.actions.ActionList;
import engine.positions.Location;
import game.Ability;
import game.actions.AttackAction;
import game.items.Sellable;
import game.actions.SellAction;
import game.actors.attributes.Status;

/***
 * MetalPipe class is a class that represents a metal pipe that can be used as a weapon to attack
 * It extends the WeaponItem class
 *
 * @author noahd
 * @version 1.0
 */
public class MetalPipe extends WeaponItem implements Sellable {

    private final static int CREDIT_VALUE = 35;

    /**
     * A constructor for the MetalPipe class
     * It sets the name, display character, damage, attack verb and accuracy
     */
    public MetalPipe() {
        super("metal pipe", '!', 1, "swings at", 20);
    }

    /**
     * Returns the list of actions that the owner of this metal pipe can do to the other actor
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return An ActionList containing the possible actions that can be done with this metal pipe to the other actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(otherActor, "(" + location.x() + "," + location.y() + ")", this));
        }

        if (otherActor.hasCapability(Ability.BE_SOLD_TO)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }

    @Override
    public void sell(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        actor.addBalance(CREDIT_VALUE);
    }

    @Override
    public String outcome() {return " sells the " + this + " for " + CREDIT_VALUE + " credits";}
}
