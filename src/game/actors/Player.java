package game.actors;

import engine.actions.Action;
import engine.actions.ActionList;
import engine.actors.Actor;
import engine.actors.attributes.BaseActorAttributes;
import engine.displays.Display;
import engine.positions.GameMap;
import engine.displays.Menu;
import engine.weapons.IntrinsicWeapon;
import game.Ability;
import game.actors.attributes.Status;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.ACCESS_FLOOR);
    }

    /**
     * Select and return an action to perform on the current turn
     * @param actions    collection of possible Actions for the Player
     * @param lastAction The Action this Player took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Player
     * @param display    the I/O object to which messages may be written
     * @return A collection of Actions
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        display.println(this.name + "\nHP: " + this.getAttribute(BaseActorAttributes.HEALTH) + "/" + this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        display.println("Balance: " + this.getBalance() + " credits");
        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    /**
     * Creates and returns an intrinsic weapon
     * @return An intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        int damage = 1; //fix to 1
        String verb = "punches";
        int hitRate = 5; //fix to 5
        return new IntrinsicWeapon(damage, verb, hitRate);
    }

}
