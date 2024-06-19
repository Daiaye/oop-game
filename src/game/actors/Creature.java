package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.attributes.Status;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.TreeMap;

/**
 * Creature class is an abstract class that represents a creature
 *
 * @author noahd
 * @version 1.0
 */
public abstract class Creature extends Actor {
    private static final int PRIORITY_WANDER_BEHAVIOUR = 999;
    /**
     * A map to store the behaviours of a Creature, mapped by their priority levels. Lower priority numbers represent higher priority behaviours
     */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * A constructor for the Creature class
     * @param name the name of Creature
     * @param displayChar display character of the Creature
     * @param hitPoints the Creature's starting hit points
     */
    public Creature(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(PRIORITY_WANDER_BEHAVIOUR, new WanderBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The allowable actions that can be done to this Creature
     * @param otherActor the Actor that might do something to this Creature
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction, otherActor.getIntrinsicWeapon()));
        }
        return actions;
    }
}
