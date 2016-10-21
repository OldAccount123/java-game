package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

public class Hammer extends AbstractActor implements Usable, Item {

    private final Animation anim;

    public Hammer(String name) {
        super(name);
        anim = new Animation("resources/sprites/hammer.png", 16, 16);
        setAnimation(anim);
    }

    @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void use(Actor actor) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
