package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Sellable;

public class SellAction extends Action {
    private final Sellable item;

    /**
     * Constructor
     * Sets the sellable associated with this sell action
     *
     * @param item the sellable item associated with this action
     */
    public SellAction(Sellable item) {this.item = item;}

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor.toString() + item.outcome();

        item.sell(actor, map);

        return result;
    }

    /**
     * A description of what the actor can do to the consumable that is displayed in the menu
     *
     * @param actor The actor performing the action.
     * @return The action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells the " + item;
    }
}
