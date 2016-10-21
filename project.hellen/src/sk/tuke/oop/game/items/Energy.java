package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Energy extends AbstractActor implements Item {

    private Ripley player;

    public Energy(String name) {
        super(name);
        Animation anim = new Animation("resources/sprites/energy.png", 16, 16);
        this.setAnimation(anim);

    }

    @Override
    public void act() {
        if (getWorld() != null) {
            for (Actor actor : getWorld()) {
                if (actor instanceof Ripley) {
                    player = (Ripley) actor;
                }
            }
        }
        if (player != null && getWorld() != null) {
            if (this.intersects(player) && player.getEnergy() < 100) {
                player.setEnergy(100);
                getWorld().removeActor(this);
            }

        }
    }

}
