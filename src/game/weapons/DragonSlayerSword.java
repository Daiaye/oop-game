package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Purchasable;

/**
 * DragonSlayerSword is a class that represents a replica of the dragon slayer sword
 * It can be used to deal large amounts of damage to enemy actors
 *
 * @author JakeK
 * @version 1.0
 */
public class DragonSlayerSword extends WeaponItem implements Purchasable {
    private static final int PRICE = 100;
    private static final double SCAM_PRICE_CHANCE = 0.5;
    private static final int DAMAGE_AMOUNT = 50;
    private static final int WEAPON_ACCURACY = 75;
    private boolean bIsError = false;

    public DragonSlayerSword() {
        super("Dragon Slayer Sword Replica", 'x', DAMAGE_AMOUNT, "went beserk at", WEAPON_ACCURACY);
    }

    public boolean purchaseBy(Actor actor) {
        if (actor.getBalance() >= PRICE) {
            if (Math.random() <= SCAM_PRICE_CHANCE) {
                this.bIsError = true;
                actor.deductBalance(PRICE);
            } else {
                this.bIsError = false;
                actor.addItemToInventory(new DragonSlayerSword());
                actor.deductBalance(PRICE);
            }
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
        return "You got scammed! " + PRICE + " credits were taken but you didn't receive the dragon slayer sword!";
    }
}
