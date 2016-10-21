package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Wrench;

public class Cooler extends AbstractActor implements Usable {

    private Animation anim;
    private Boolean state;
    private Ripley ripley;

    public Cooler(String name) {
        super(name);
        anim = new Animation("resources/sprites/fan.png", 32, 32, 200);
        setAnimation(anim);
        anim.stop();
        state = false;
    }

    @Override
    public void act() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void use(Actor actor) {
        if (actor instanceof Wrench || actor instanceof Hammer) {
            for (Actor postava : getWorld()) {
                if (postava instanceof Ripley) {
                    ripley = (Ripley) postava;
                }
            }
            ripley.getBackpack().remove(ripley.getBackpack().getLastItem());
            anim.start();
            state = true;
        }

    }

    /**
     * @return the state
     */
    public Boolean getState() {
        return state;
    }

}
