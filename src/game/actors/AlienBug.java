package game.actors;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickUpBehaviour;
import game.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class AlienBug extends Creature {

    private static final int PRIORITY_FOLLOW_BEHAVIOUR = 50;
    private static final int PRIORITY_PICKUP_BEHAVIOUR = 1;

    public AlienBug() {
        super("Feature-" + Utility.randomThreeDigitID(), 'a', 2);
        this.behaviours.put(PRIORITY_PICKUP_BEHAVIOUR, new PickUpBehaviour());
        this.addCapability(Ability.ACCESS_FLOOR);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);

        Location location = map.locationOf(this);
        for (Exit exit : location.getExits()) {
            if (exit.getDestination().containsAnActor() && exit.getDestination().getActor() == otherActor) {
                this.behaviours.put(PRIORITY_FOLLOW_BEHAVIOUR, new FollowBehaviour(otherActor));
            }
        }
        return actions;
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        List<Item> inventory = new ArrayList<>(this.getItemInventory());
        for (Item item : inventory) {
            this.removeItemFromInventory(item);
            map.locationOf(this).addItem(item);
        }
        map.removeActor(this);
        return this + " met their demise at the hand of " + actor + " and dropped " + inventory.size() + " scraps ";

    }





}
