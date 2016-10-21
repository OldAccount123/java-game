package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.openables.LockedDoor;

/**
 *
 * @author Mato
 */
public class WaitingAlien extends Alien implements Observer {

    private boolean state = false;

    public WaitingAlien(String name) {
        super(name);
    }

    @Override
    public void act() {
        LockedDoor door = (LockedDoor) getActorByName("waiting1");
        if (door != null) {
            door.addObserver(this);
        } else {
            door = (LockedDoor) getActorByName("waiting2");
            if (door != null) {
                door.addObserver(this);
            }
        }
        if (state == true) {
            super.act();
        }
    }

    @Override
    public void giveNotice() {
        state = true;
    }
}
