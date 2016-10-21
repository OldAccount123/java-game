package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

public abstract class AbstractActor implements Actor {

    private int xCor, yCor;
    private Animation anim;
    private World world;
    private String name;

    public AbstractActor() {

    }

    public AbstractActor(String name) {
        this.name = name;
    }

    public AbstractActor(String name, boolean vertical) {
        this.name = name;
    }

    @Override
    public int getX() {
        return xCor;
    }

    @Override
    public int getY() {
        return yCor;
    }

    @Override
    public void setPosition(int x, int y) {
        this.xCor = x;
        this.yCor = y;
    }

    @Override
    public Animation getAnimation() {
        return anim;
    }

    @Override
    public void setAnimation(Animation animation) {
        this.anim = animation;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWidth() {
        if (this.getAnimation() != null) {
            return this.getAnimation().getWidth();
        }
        return 0;
    }

    @Override
    public int getHeight() {
        if (this.getAnimation() != null) {
            return this.getAnimation().getHeight();
        }
        return 0;
    }

    @Override
    public boolean intersects(Actor actor) {
        int actorX = actor.getX();
        int actorY = actor.getY();
        int actorWidth = actor.getWidth();
        int actorHeight = actor.getHeight();
        int thisX = this.getX();
        int thisY = this.getY();
        int thisWidth = this.getWidth();
        int thisHeight = this.getHeight();
        //trosku zbytocne zlozite, ale :)...
        return ((thisX + (thisWidth) >= actorX
                && thisX <= actorX + (actorWidth)))
                && ((thisY <= actorY + (actorHeight)
                && thisY + (thisHeight) >= actorY));

    }

    @Override
    public void addedToWorld(World world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "Meno" + this + " Pozicia jex: " + this.xCor
                + "y: " + this.yCor + "Rotacia je "
                + this.getAnimation().getRotation();
    }

    /**
     *
     * @return list of intersecting actors with selected actor.
     */
    public List getIntersectingActors() {
        List<Actor> intersectingActors = new ArrayList<>();
        if (getWorld() != null) {
            for (Actor actor : getWorld()) {
                if (actor != this && actor.intersects(this)) {
                    intersectingActors.add(actor);
                }
            }
        }
        return intersectingActors;
    }

    public Actor getActorByName(String name) {
        Actor foundActor = null;
        for (Actor actor : getWorld()) {
            if (actor.getName() == name) {
                foundActor = actor;
            }
        }
        return foundActor;
    }

}
