package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Matej Gazda
 */
public class AlienEgg extends AbstractActor implements Usable {

    private int time;
    private int i = 0;
    private boolean hit = false;

    public AlienEgg(String name) {
        super(name);
        time = 1;
        setAnimation(new Animation("resources/sprites/alien_egg.png", 32, 32));
    }

    @Override
    public void act() {
        getWorld().setWall(this.getX() / 32, this.getY() / 32, true);
        Alien enemy;
        if (i % 1500 == 0) {
            enemy = new Alien("alien");
            enemy.setPosition(this.getX(), this.getY());
            getWorld().addActor(enemy);
            i = 0;
        }
        if (time > 0 && hit == true) {
            time++;
            if (time > 25) {
                getWorld().setWall(this.getX() / 32, this.getY() / 32, false);
                getWorld().removeActor(this);
            }
        }
        i++;
    }

    @Override
    public void use(Actor actor) {
        if (actor instanceof Ripley) {
            setAnimation(new Animation("resources/sprites/large_explosion.png", 32, 32));
            hit = true;
        }
    }

}
