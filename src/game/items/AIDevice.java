package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.MonologueAction;
import java.util.ArrayList;

/**
 * AIDevice is a class that represents Astley, an AI device
 * It can be used to monologue a random string to the user
 *
 * @author JakeK
 * @version 1.0
 */
public class AIDevice extends Item implements Purchasable, Monologuable{
    private static final int PRICE = 50;
    private boolean bCanUse = true;
    private static final double TICK_COUNT = 5;
    private double TURN_TO_TICK = 0;
    private boolean bIsError = false;

    public AIDevice() {
        super("Astley", 'z', true);
    }

    @Override
    public ArrayList<String> monologue(Actor actor) {
        ArrayList<String> monologueOptions = new ArrayList<String>();
        monologueOptions.add("The factory will never gonna give you up, valuable intern!");
        monologueOptions.add("We promise we never gonna let you down with a range of staff benefits.");
        monologueOptions.add("We never gonna run around and desert you, dear intern!");
        if(actor.getItemInventory().size() > 10) {
            monologueOptions.add("We never gonna make you cry with unfair compensation.");
        }
        if(actor.getBalance()>50) {
            monologueOptions.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");
        }
        if(actor.getAttribute(BaseActorAttributes.HEALTH) < 2) {
            monologueOptions.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        }
        return monologueOptions;
    }
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if(actor.getItemInventory().contains(this)) {
            if (TURN_TO_TICK >= TICK_COUNT) {

                if (actor.getBalance() >= 1) {
                    actor.deductBalance(1);
                    bCanUse = true;
                    TURN_TO_TICK = 0;
                } else {
                    bCanUse = false;
                }
            }
            else {
                TURN_TO_TICK += 1;
            }
        }
        else {
            bCanUse = false;
        }
    }
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        if (bCanUse) {
            actions.add(new MonologueAction(this));
        }
        return actions;
    }
    public boolean purchaseBy(Actor actor) {
        if (actor.getBalance() >= getPrice()) {
            actor.addItemToInventory(new AIDevice());
            actor.deductBalance(getPrice());
            return true;
        } else {
            return false;
        }
    }
    public int getPrice() {
        return PRICE;
    }
    public boolean getIsError() {
        return this.bIsError;
    }
    public String getErrorMessage(Actor actor) {
        return "";
    }
}
