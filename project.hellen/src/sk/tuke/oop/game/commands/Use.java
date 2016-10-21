package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.actors.openables.Openable;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.AccessCard;

public class Use implements Command {

    private Actor actor = null;
    private final Actor actuator;
    private Ripley ripley;
    private Usable item;
    private Openable itemOpenable = null;

    public Use(Actor actor, Actor actuator) {
        this.actor = actor;
        this.actuator = actuator;  //karta
    }

    @Override
    public void execute() {
        Openable itemOpen = null;
        LockedDoor lockDoor = null;
        if (actor instanceof LockedDoor && actuator instanceof AccessCard) {
            lockDoor = (LockedDoor) actor;
            lockDoor.unlock();
            for (Actor postava : actor.getWorld()) {
                if (postava instanceof Ripley) {
                    ripley = (Ripley) postava;
                }
            }
            ripley.getBackpack().remove(ripley.getBackpack().getLastItem());
        } else if (!(actor instanceof Openable)) {
            item = (Usable) actor;
            item.use(actuator);
        } else if (actor instanceof Openable && !(actor instanceof LockedDoor)) {
            itemOpenable = (Openable) actor;
            if (itemOpenable.isOpen()) {
                itemOpenable.close();
            } else {
                itemOpenable.open();
            }
        } else if (actor instanceof LockedDoor) {
            lockDoor = (LockedDoor) actor;
            if (lockDoor.isLocked() == false) {
                itemOpenable = (Openable) actor;
                if (itemOpenable.isOpen()) {
                    itemOpenable.close();
                } else {
                    itemOpenable.open();
                }
            }
        }

    }
}
