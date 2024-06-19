package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Ability;

public class HumanoidFigure extends Actor {

    /**
     * A constructor for the HumanoidFigure class
     */
    public HumanoidFigure() {
        super("Humanoid Figure",'H', 0);
        this.addCapability(Ability.BE_SOLD_TO);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
