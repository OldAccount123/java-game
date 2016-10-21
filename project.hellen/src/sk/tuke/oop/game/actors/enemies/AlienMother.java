package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author Matej Gazda
 */
public class AlienMother extends Alien {

    private int energy;

    public AlienMother(String name) {
        super(name);
        setAnimation(new Animation("resources/sprites/mother.png", 112, 162, 200));
        this.setEnergy(200);
    }
}
