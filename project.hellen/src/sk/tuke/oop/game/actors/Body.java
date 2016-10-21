package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Wrench;
import sk.tuke.oop.game.items.Money;

public class Body extends AbstractActor {

    private final Animation anim;
    private String name;
    private BackpackImpl backpack = new BackpackImpl(2);

    public Body(String name) {
        super(name);
        anim = new Animation("resources/sprites/body.png", 64, 48);
        setAnimation(anim);
        backpack.add(new Wrench("Wrenchik"));
        backpack.add(new Hammer("Hammerik"));
        backpack.add(new Money("Penazky"));
    }

    @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the backpack
     */
    public BackpackImpl getBackpack() {
        return backpack;
    }

}
