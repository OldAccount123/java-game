package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

public class TakeItem implements Command {

    private final BackpackImpl bpItems;
    private final Item item;
    private Actor actor;
    private World world;

    public TakeItem(BackpackImpl backpack, Item item) {
        bpItems = backpack;
        this.item = item;

    }

    @Override
    public void execute() {
        if (bpItems != null && item != null) {
            bpItems.add(item);
            world = item.getWorld();
            world.removeActor(item);
        }

    }
}
