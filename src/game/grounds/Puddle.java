package game.grounds;

import engine.actions.ActionList;
import engine.actors.Actor;
import engine.actors.attributes.ActorAttributeOperations;
import engine.actors.attributes.BaseActorAttributes;
import engine.positions.Ground;
import engine.positions.Location;
import game.actions.ConsumeAction;
import game.items.Consumable;

/**
 * Puddle class is a class that represents a puddle
 *
 * It can be consumed to increase an actors max hp by 1
 *
 * @author RichieC
 * @version 1.0
 */
public class Puddle extends Ground implements Consumable {

    private static final int HEALTH_MODIFIER = 1;

    /**
     * A constructor for the Puddle class
     */
    public Puddle() {
        super('~');
    }

    public ActionList allowableActions(Actor actor, Location location, String direction) {
         if (location.getActor() == actor) {
             return new ActionList(new ConsumeAction(this));
         }
         return new ActionList();
    }

    @Override
    public void consume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, HEALTH_MODIFIER);
    }

    @Override
    public String verb() {
        return "drinks";
    }

    @Override
    public String effect() {
        return "increases their max HP by " + HEALTH_MODIFIER + ". Tastes disgusting but water is water.";
    }

    @Override
    public String toString() {
        return "puddle";
    }

}
