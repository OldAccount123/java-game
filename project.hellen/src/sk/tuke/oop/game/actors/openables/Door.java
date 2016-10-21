package sk.tuke.oop.game.actors.openables;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.items.Usable;

public class Door extends AbstractActor implements Usable, Openable {

    private World world;
    private boolean status = false; //checks whether the key was used .
    private boolean opened; // chjeck the status of doors
    private List<Observer> listObservers = new ArrayList<>(5);

    public Door(String name) {
        super(name);
    }

    public Door(String name, boolean vertical) {
        super(name);
        opened = false;
        if (vertical == false) {
            Animation anim = new Animation("resources/sprites/vdoor.png", 16, 32, 100);
            anim.setPingPong(true);
            anim.stop();
            setAnimation(anim);
        } else {
            Animation anim = new Animation("resources/sprites/hdoor.png", 32, 16, 100);
            anim.setPingPong(true);
            anim.stop();
            setAnimation(anim);
        }
    }

    @Override
    public void act() {
        if (world == null && getWorld() != null) {
            this.world = getWorld();
            world.setWall(this.getX() / 16, this.getY() / 16, true);
        }
    }

    @Override
    public void use(Actor actor) {
        if (opened) {
            close();
        } else {
            open();
        }
    }

    @Override
    public void open() {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, false);
        opened = true;
        if (listObservers != null) {
            for (Observer observer : this.listObservers) {
                observer.giveNotice();
            }
        }
        this.getAnimation().start();
        this.getAnimation().stopAt(3);
    }

    @Override
    public void close() {
        getWorld().setWall(this.getX() / 16, this.getY() / 16, true);
        opened = false;
        this.getAnimation().start();
        this.getAnimation().stopAt(0);

    }

    @Override
    public boolean isOpen() {
        return opened;
    }

    public void addObserver(Observer observer) {
        listObservers.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (listObservers.contains(observer)) {
            listObservers.remove(observer);
        }
    }

}
