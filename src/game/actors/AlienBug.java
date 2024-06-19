package game.actors;
import engine.actions.Action;
import engine.actions.ActionList;
import engine.actions.DoNothingAction;
import engine.actors.Actor;
import engine.actors.Behaviour;
import engine.displays.Display;
import engine.items.DropAction;
import engine.items.Item;
import engine.positions.Exit;
import engine.positions.GameMap;
import engine.positions.Location;
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
