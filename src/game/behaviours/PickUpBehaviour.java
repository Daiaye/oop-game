package game.behaviours;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PickUpBehaviour implements Behaviour {
    private final Random random = new Random();
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        List<Item> itemList = here.getItems();

        if (itemList.isEmpty()) {
            return null;
        }

        List<Item> portableItems = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getPickUpAction(actor) != null) {
                portableItems.add(item);
            }
        }

        Item randomItem = portableItems.get(random.nextInt(portableItems.size()));

        return new PickUpAction(randomItem);
    }
}
