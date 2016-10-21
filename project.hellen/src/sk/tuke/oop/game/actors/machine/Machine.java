package sk.tuke.oop.game.actors.machine;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;

/**
 *
 * @author Matej Gazda
 */
public class Machine extends AbstractActor {

    public Machine(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/trap_system.png", 16, 16));
    }

    public void floorSwitchActivated() {

    }

    public void wallSwitchActivated() {

    }

    public void leverRetracted() {

    }

    @Override
    public void act() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
