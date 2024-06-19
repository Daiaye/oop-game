package game.behaviours;
import engine.actions.Action;
import engine.actors.Actor;
import engine.actors.Behaviour;
import engine.items.Item;
import engine.items.PickUpAction;
import engine.positions.GameMap;
import engine.positions.Location;

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
