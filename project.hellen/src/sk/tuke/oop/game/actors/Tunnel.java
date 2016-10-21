package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.Usable;

/**
 *
 * @author Matej Gazda
 */
public class Tunnel extends AbstractActor implements Usable {

    private Ripley player;
    private Switch spinac;

    public Tunnel(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/tunnel_black.png", 32, 32, 100));
    }

    @Override
    public void use(Actor actor) {
        for (Actor actor2 : actor.getWorld()) {
            if (actor2 instanceof Switch) {
                spinac = (Switch) actor2;
            }
        }

        if (actor instanceof Ripley && spinac.isState()) {
            player = (Ripley) actor;
            player.setPosition(player.getX() - 70, player.getY());
        }

    }

    @Override
    public void act() {

    }

}
