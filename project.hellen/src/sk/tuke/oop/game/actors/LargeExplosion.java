package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Matej Gazda
 */
public class LargeExplosion extends AbstractActor {

    private Ripley player;

    public LargeExplosion(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/large_explosion.png", 32, 32));
    }

    @Override
    public void act() {
        if (player == null) {
            for (Actor actor : getWorld()) {
                if (actor instanceof Ripley) {
                    player = (Ripley) actor;
                }
            }
        }
        if (player != null && this.intersects(player)) {
            player.setEnergy(player.getEnergy() - 40);
        }
    }
}
