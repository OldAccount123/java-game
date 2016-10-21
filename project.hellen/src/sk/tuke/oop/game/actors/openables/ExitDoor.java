package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Matej Gazda
 */
public class ExitDoor extends Door implements Usable {

    private boolean opened = false;

    public ExitDoor(String name, boolean vertical) {
        super(name, vertical);
    }

    @Override
    public void use(Actor actor) {
        System.out.println("Well Done!");
        super.use(actor);

    }

}
