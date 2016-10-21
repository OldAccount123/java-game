package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

public class DropItem implements Command {

    private final BackpackImpl bpItems;
    private final World world;
    private final int x, y;

    public DropItem(BackpackImpl backpack, World world, int x, int y) {
        bpItems = backpack;
        this.world = world;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        Actor actor = bpItems.getLastItem();
        world.addActor(actor);
        actor.setPosition(x, y);
        bpItems.remove((Item) actor);
    }
}
