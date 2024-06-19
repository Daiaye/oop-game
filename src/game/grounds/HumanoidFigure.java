package game.grounds;

import engine.actions.Action;
import engine.actions.ActionList;
import engine.actions.DoNothingAction;
import engine.actors.Actor;
import engine.displays.Display;
import engine.positions.GameMap;
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
