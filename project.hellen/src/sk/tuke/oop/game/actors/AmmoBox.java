package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Matej Gazda
 */
public class AmmoBox extends AbstractActor implements Usable {

    public AmmoBox(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/box_large.png", 16, 16));
    }

    @Override
    public void act() {
    }

    @Override
    public void use(Actor actor) {
        Ammo ammo = new Ammo("ammo");
        ammo.setPosition(this.getX(), this.getY());
        getWorld().addActor(ammo);
        getWorld().removeActor(this);
    }
}
