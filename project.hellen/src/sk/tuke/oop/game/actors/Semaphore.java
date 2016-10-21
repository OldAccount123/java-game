package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author Matej Gazda
 */
public class Semaphore extends AbstractActor {

    private Switch spinac;
    private Animation off, on;

    public Semaphore(String name) {
        super(name);
        off = new Animation("resources/sprites/button_red.png", 16, 16);
        on = new Animation("resources/sprites/button_green.png", 16, 16);
        setAnimation(off);
    }

    private void findSpinac() {
        for (Actor actor : getWorld()) {
            if (actor instanceof Switch) {
                spinac = (Switch) actor;
            }
        }
    }

    @Override
    public void act() {
        if (spinac == null) {
            findSpinac();
        } else if (spinac.isState()) {
            setAnimation(on);
        } else {
            setAnimation(off);
        }
    }

}
