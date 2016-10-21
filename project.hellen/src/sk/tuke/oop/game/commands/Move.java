package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.Movable;

public class Move implements Command {

    private final Movable actor;
    private int step, dx, dy;

    public Move(Movable actor, int step, int dx, int dy) {
        this.actor = actor;
        this.step = step;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute() {
        Animation animation;
        actor.setPosition(actor.getX() + (dx * step), actor.getY() + (dy * step));
        animation = actor.getAnimation();
        if (animation != null) {
            animation.start();
            if (dx > 0 && dy == 0) {
                animation.setRotation(90);
            } else if (dx < 0 && dy == 0) {
                animation.setRotation(270);
            } else if (dy > 0 && dx == 0) {
                animation.setRotation(180);
            } else if (dy < 0 && dx == 0) {
                animation.setRotation(0);
            } else if (dx > 0 && dy > 0) {
                animation.setRotation(135);
            } else if (dx < 0 && dy < 0) {
                animation.setRotation(315);
            } else if (dx > 0 && dy < 0) {
                animation.setRotation(45);
            } else if (dx < 0 && dy > 0) {
                animation.setRotation(235);
            }
            if (actor.getWorld().intersectWithWall(actor) && actor.getClass() != Bullet.class) {
                actor.setPosition(actor.getX() - (dx * step), actor.getY() - (dy * step));
            }
        }
    }
}
