package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

public class Ventilator extends AbstractActor implements Usable {

    private int state;
    private final Animation anim;

    public Ventilator(String name) {
        super(name);
        anim = new Animation("resources/sprites/ventilator.png", 32, 32, 100);
        this.setAnimation(anim);
        anim.stop();
        state = 0;

    }

    @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void use(Actor actor) {
        if (state == 0) {
            state = 1;
            anim.start();//zapnutie animacky
        } else {
            state = 0;
            anim.stop();
        }
    }

}
