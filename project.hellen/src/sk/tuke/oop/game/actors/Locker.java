package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.items.Hammer;

public class Locker extends AbstractActor implements Usable {

    private boolean empty = false;
    private final BackpackImpl backpack;

    public Locker(String name) {
        super(name);
        backpack = new BackpackImpl(1);
        backpack.add(new Hammer("Hammer"));
        Animation anim = new Animation("resources/sprites/locker.png", 16, 16);
        setAnimation(anim);

    }

    @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void use(Actor actor) {
        if (!empty) {
            DropItem drop = new DropItem(backpack, actor.getWorld(), this.getX(), this.getY());
            drop.execute();
            empty = true;
        }
    }
}
