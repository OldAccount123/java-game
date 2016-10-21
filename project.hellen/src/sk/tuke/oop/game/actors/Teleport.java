package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Matej Gazda
 */
public class Teleport extends AbstractActor implements Usable {

    public Teleport(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/lift.png", 48, 48));
    }

    @Override
    public void act() {

    }

    @Override
    public void use(Actor actor) {
        Computer computer = (Computer) getActorByName("computer");
        if (computer != null && !computer.isBroken()) {
            System.out.println("Good Game you Won!");
            System.exit(0);
        }
    }

}
