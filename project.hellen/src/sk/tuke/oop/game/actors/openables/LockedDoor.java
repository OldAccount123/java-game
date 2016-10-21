package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Usable;

public class LockedDoor extends Door implements Usable {

    private boolean locked;
    private boolean open;

    public LockedDoor(String name, boolean vertical) {
        super(name, vertical);
        locked = true;
        open = false;
    }

    @Override
    public void use(Actor actor) {
        if (open == true && !isLocked() && actor instanceof Ripley) {
            close();
        } else if (!isLocked() && open == false && actor instanceof Ripley) {
            open();
        }
    }

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }
}
