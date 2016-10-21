package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Animation;
import java.util.*;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Command;

public class Alien extends AbstractCharacter implements Movable, Enemy {

    private final Animation enemy;
    private Command myCommand;
    private int energy = 100;
    private int xCor, yCor;
    private int direction;
    private Random randomNumber = new Random();
    private int i = 0;

    public Alien(String name) {
        super(name);
        enemy = new Animation("resources/sprites/warrior_alien.png", 32, 32, 100);
        this.setAnimation(enemy);
    }

    @Override
    public void act() {
        Ripley ripley = null;
        int step = 2; // how many pixels is 1 step.
        int x = this.getX();
        int y = this.getY();
        enemy.stop(); //zastavim animaciu aby neprekracoval na mieste.
        //every 100th round it picks randomly direction and walks.
        if (i == 100) {
            direction = randomNumber.nextInt(9);
            i = 0;
        }
        if (direction == 0) {
            myCommand = new Move(this, step, 0, 1);
            myCommand.execute();
        } else if (direction == 1) {
            myCommand = new Move(this, step, 1, 0);
            myCommand.execute();
        } else if (direction == 2) {
            myCommand = new Move(this, step, 0, -1);
            myCommand.execute();
        } else if (direction == 3) {
            myCommand = new Move(this, step, -1, 0);
            myCommand.execute();
        } else if (direction == 4) {
            myCommand = new Move(this, step, 1, 1);
            myCommand.execute();
        } else if (direction == 5) {
            myCommand = new Move(this, step, 1, -1);
            myCommand.execute();
        } else if (direction == 6) {
            myCommand = new Move(this, step, -1, 1);
            myCommand.execute();
        } else if (direction == 7) {
            myCommand = new Move(this, step, -1, -1);
            myCommand.execute();
        } else if (direction == 8) {
            myCommand = new Move(this, step, 0, 0);
            myCommand.execute();
        }
        for (Actor actor : getWorld()) {
            if (actor instanceof Ripley && actor.intersects(this)) {
                ripley = (Ripley) actor;
                if (ripley.getEnergy() > 0) {
                    ripley.setEnergy(ripley.getEnergy() - 1);
                }
            }
        }
        i++; // i represents time in the game.
        if (getWorld() != null) {
            Bullet bullet = null;
            for (Actor actor : getWorld()) {
                if (this.intersects(actor) && actor instanceof Bullet) {
                    setEnergy(getEnergy() - 10);
                    bullet = (Bullet) actor;
                    System.out.println(energy);
                    break;
                }
            }
            this.getWorld().removeActor(bullet);
        }
        if (this.getEnergy() <= 0) {
            this.getWorld().removeActor(this);
        }
    }

    /**
     * @return the energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
