package sk.tuke.oop.game.actors.machine;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author Matej Gazda
 */
public class Lever extends AbstractActor {

    public Lever(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/invisible.png", 16, 16));
    }

    @Override
    public void act() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
