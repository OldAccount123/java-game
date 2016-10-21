package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.commands.Command;

/**
 *
 * @author Matej Gazdajj
 */
public class Bullet extends AbstractActor implements Movable {

    private Ripley ripley;
    private int ripleyDirection = -1, x, y;
    private Command myCommand = null;
    private World world;
    private Animation anim;

    public Bullet(String name) {
        super(name);
        anim = new Animation("resources/sprites/bullet.png", 16, 16);
    }

    public void initialize(Ripley ripley) {
        ripley.getWorld().addActor(this);
        setAnimation(anim);
        ripleyDirection = ripley.getAnimation().getRotation();
        setPosition(ripley.getX(), ripley.getY());
    }

    public void go() {

        switch (ripleyDirection) {
            case 0:
                myCommand = new Move(this, 1, 0, -1);
                myCommand.execute();
                break;
            case 45:
                myCommand = new Move(this, 1, 1, -1);
                myCommand.execute();
                break;
            case 90:
                myCommand = new Move(this, 1, 1, 0);
                myCommand.execute();
                break;
            case 135:
                myCommand = new Move(this, 1, 1, 1);
                myCommand.execute();
                break;
            case 180:
                myCommand = new Move(this, 1, 0, 1);
                myCommand.execute();
                break;
            case 225:
                myCommand = new Move(this, 1, -1, 1);
                myCommand.execute();
                break;
            case 270:
                myCommand = new Move(this, 1, -1, 0);
                myCommand.execute();
                break;
            case 315:
                myCommand = new Move(this, 1, -1, -1);
                myCommand.execute();
                break;
        }
    }

    @Override
    public void act() {
        go();
        if (getWorld().intersectWithWall(this)) {
            getWorld().removeActor(this);
        }
    }

}
