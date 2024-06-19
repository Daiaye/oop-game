package game.actions;

import engine.actions.Action;
import engine.actors.Actor;
import engine.positions.GameMap;
import game.items.Purchasable;

public class PurchaseAction extends Action {
    private final Purchasable purchasable;
    public PurchaseAction(Purchasable purchasable) {
        this.purchasable = purchasable;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        if (purchasable.purchaseBy(actor)) {
            if (purchasable.getIsError()) {
                return purchasable.getErrorMessage(actor);
            }
            return actor + " purchases " + purchasable + " for " + purchasable.getPrice() + " credits";
        } else {
            if (purchasable.getIsError()) {
                return purchasable.getErrorMessage(actor);
            }
            int missingCredits = purchasable.getPrice() - actor.getBalance();
            return "Purchase failed! " + actor + " is missing " + missingCredits + " credits";
        }
    }
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + purchasable + " for $" + purchasable.getPrice();
    }

}
