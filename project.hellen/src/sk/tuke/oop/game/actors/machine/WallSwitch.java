package sk.tuke.oop.game.actors.machine;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author Matej Gazda
 */
public class WallSwitch extends AbstractActor {

    public WallSwitch(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/wall_switch.png", 16, 16));
    }

    @Override
    public void act() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
