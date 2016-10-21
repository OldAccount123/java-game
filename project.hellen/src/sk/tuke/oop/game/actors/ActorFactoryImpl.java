package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.actors.enemies.AlienMother;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.enemies.WaitingAlien;
import sk.tuke.oop.game.actors.openables.ExitDoor;
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.actors.machine.FloorSwitch;
import sk.tuke.oop.game.actors.machine.Lever;
import sk.tuke.oop.game.actors.machine.Machine;
import sk.tuke.oop.game.actors.machine.WallSwitch;  
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Energy;

public class ActorFactoryImpl implements ActorFactory {

    @Override
    public Actor create(String string, String string1) {
        if (string1 == null) {
            return null;
        }
        if (string1.equalsIgnoreCase("Access card")) {
            return new AccessCard("Access card");
        } else if (string1.equalsIgnoreCase("Energy")) {
            return new Energy("Energy");
        } else if (string1.equalsIgnoreCase("ammo")) {
            return new Ammo("ammo");
        } else if (string1.equalsIgnoreCase("Cooler")) {
            return new Cooler("Cooler");
        } else if (string1.equalsIgnoreCase("front door")) {
            if (string.equalsIgnoreCase("vertical")) {
                return new LockedDoor(string1, false);
            } else if (string.equalsIgnoreCase("horizontal")) {
                return new LockedDoor(string1, true);
            }
            if (string.equalsIgnoreCase("waiting1")) {
                return new LockedDoor("waiting1", false);
            }
        } else if (string1.equalsIgnoreCase("back door")) {
            if (string.equalsIgnoreCase("vertical")) {
                return new LockedDoor(string1, false);
            }
        } else if (string1.equalsIgnoreCase("exit door")) {
            if (string.equalsIgnoreCase("horizontal")) {
                return new ExitDoor(string1, true);
            } else {
                return new ExitDoor(string1, false);
            }
        } else if (string1.equalsIgnoreCase("ellen")) {
            return new Ripley("ellen");
        } else if (string1.equalsIgnoreCase("Locker")) {
            return new Locker("Locker");
        } else if (string1.equalsIgnoreCase("Machine")) {
            return new Machine("Machine");
        } else if (string1.equalsIgnoreCase("Lever")) {
            return new Lever("Lever");
        } else if (string1.equalsIgnoreCase("FloorSwitch")) {
            return new FloorSwitch("FloorSwitch");
        } else if (string1.equalsIgnoreCase("WallSwitch")) {
            return new WallSwitch("WallSwitch");
        } else if (string1.equalsIgnoreCase("alien mother")) {
            return new AlienMother("alien mother");
        } else if (string1.equalsIgnoreCase("alien")) {
            return new Alien("alien");
        } else if (string1.equalsIgnoreCase("waiting alien")) {
            return new WaitingAlien("waiting alien");
        } else if (string1.equalsIgnoreCase("bullet")) {
            return new Bullet("bullet");
        } else if (string1.equalsIgnoreCase("tunnel")) {
            return new Tunnel("tunnel");
        } else if (string1.equalsIgnoreCase("barrel")) {
            return new Barrel("barrel");
        } else if (string1.equalsIgnoreCase("switch")) {
            return new Switch("switch");
        } else if (string1.equalsIgnoreCase("semaphore")) {
            return new Semaphore("semaphore");
        } else if (string1.equalsIgnoreCase("teleport")) {
            return new Teleport("teleport");
        } else if (string1.equalsIgnoreCase("computer")) {
            return new Computer("computer");
        } else if (string1.equalsIgnoreCase("large explosion")) {
            return new LargeExplosion("large explosion");
        } else if (string1.equalsIgnoreCase("alien egg")) {
            return new AlienEgg("alien egg");
        } else if (string1.equalsIgnoreCase("ammo box")) {
            return new AmmoBox("ammo box");
        }
        return null;
    }
}
