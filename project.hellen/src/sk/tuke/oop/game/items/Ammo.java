package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Ammo extends AbstractActor implements Item {

    private Ripley player;

    public Ammo(String name) {
        super(name);
        Animation anim = new Animation("resources/sprites/ammo.png", 16, 16);
        this.setAnimation(anim);

    }

    @Override
    public void act() {
        if (this.getWorld() != null) {
            for (Actor actor : getWorld()) {
                if (actor instanceof Ripley) {
                    player = (Ripley) actor;
                }
            }
        }
        if (player != null && this.getWorld() != null) {
            if (this.intersects(player) && player.getAmmo() < 500) {
                player.setAmmo(player.getAmmo() + 50);
                this.getWorld().removeActor(this);
                if (player.getAmmo() > 500) {
                    player.setAmmo(500);
                }
            }
        }
    }
}
