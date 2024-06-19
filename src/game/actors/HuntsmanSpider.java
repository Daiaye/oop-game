package game.actors;

import engine.actions.ActionList;
import engine.actors.Actor;
import engine.positions.GameMap;
import engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.actors.attributes.Status;

/**
 * HuntsmanSpider class is a class that represents a huntsman spider
 *
 * @author noahd
 * @version 1.0
 */
public class HuntsmanSpider extends Creature {
    private static final int PRIORITY_ATTACK_BEHAVIOUR = 0;
    private static final int ATTACK_DAMAGE = 1;
    private static final String ATTACK_VERB = "uses long leg to stab";
    private static final int ATTACK_HITRATE = 25;
    /**
     * A constructor for the HuntsmanSpider class
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(PRIORITY_ATTACK_BEHAVIOUR, new AttackBehaviour());
    }
    /**
     * Creates and returns an intrinsic weapon
     * @return An intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(ATTACK_DAMAGE, ATTACK_VERB, ATTACK_HITRATE);
    }
}
