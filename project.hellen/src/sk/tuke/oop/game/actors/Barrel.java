package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author Matej Gazda
 */
public class Barrel extends AbstractActor {

    private int time = 0;

    public Barrel(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/barrel.png", 16, 16));
    }

    @Override
    public void act() {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
        for (Actor actor : getWorld()) {
            if (actor instanceof Bullet && this.intersects(actor)) {
                setAnimation(new Animation("resources/sprites/small_explosion.png", 16, 16));
                time++;
                break;
            }
        }

        if (time > 0) {
            time++;
            if (time > 25) {
                getWorld().setWall(this.getX() / 16, this.getY() / 16, false);
                getWorld().removeActor(this);
            }
        }

    }

}
