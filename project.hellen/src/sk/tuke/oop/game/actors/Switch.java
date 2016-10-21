package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Matej Gazda
 */
public class Switch extends AbstractActor implements Usable {

    private boolean state = false;

    public Switch(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/switch.png", 16, 16));
    }

    @Override
    public void act() {

    }

    @Override
    public void use(Actor actor) {
        if (actor instanceof Ripley) {
            changeState();
        }
    }

    public void changeState() {
        if (!isState()) {
            state = true;
        } else {
            state = false;
        }
    }

    /**
     * @return the state
     */
    public boolean isState() {
        return state;
    }

}
