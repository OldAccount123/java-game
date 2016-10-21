package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;

public class Wrench extends AbstractActor implements Item, Usable {

    private final Animation anim;

    public Wrench(String name) {
        super(name);
        anim = new Animation("resources/sprites/wrench.png", 16, 16);
        this.setAnimation(anim);
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
