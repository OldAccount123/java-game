package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.ripley.Ripley;

/**
 *
 * @author Matej Gazda
 */
public class Shoot implements Command {

    private Ripley ripley;
    private Bullet bullet = new Bullet("bullet");

    public Shoot(Ripley ripley) {
        this.ripley = ripley;
    }

    @Override
    public void execute() {
        Bullet bullet = (Bullet) this.bullet;
        bullet.initialize(ripley);
        bullet.go();
    }

}
