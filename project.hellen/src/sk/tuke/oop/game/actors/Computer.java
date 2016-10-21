package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Matej Gazda
 */
public class Computer extends AbstractActor implements Usable {

    private boolean broken = true;

    public Computer(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/computer.png", 80, 48));
    }

    @Override
    public void act() {

    }

    @Override
    public void use(Actor actor) {
        broken = false;
    }

    /**
     * @return the broken
     */
    public boolean isBroken() {
        return broken;
    }

}
