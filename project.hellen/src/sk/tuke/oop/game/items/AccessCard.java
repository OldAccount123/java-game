package sk.tuke.oop.game.items;

import sk.tuke.oop.game.commands.Use;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.commands.Command;

public class AccessCard extends AbstractActor implements Usable, Item {

    public AccessCard(String name) {
        super(name);
        Animation anim = new Animation("resources/sprites/key.png", 16, 16);
        setAnimation(anim);
    }

    @Override
    public void use(Actor actor) {
        for (Actor findDoors : getWorld()) {
            if (findDoors instanceof LockedDoor) {
                Command myCommand;
                myCommand = new Use(findDoors, this);
                myCommand.execute();
            }
        }
    }

    @Override
    public void act() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
