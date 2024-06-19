package game.actors;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

public class SuspiciousAstronaut extends Creature {

    private static final int PRIORITY_ATTACK_BEHAVIOUR = 0;

    private static final int ATTACK_DAMAGE = Integer.MAX_VALUE;
    private static final String ATTACK_VERB = "BONKS";
    private static final int ATTACK_HITRATE = 100;

    /**
     * Constructor for the SuspiciousAstronaut class
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", 'ඞ', 99);
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

    // Can fix attackaction so it doesn't display a ridiculously large number
}