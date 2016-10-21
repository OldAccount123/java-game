package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;

public class Dying implements RipleyState {

    private Ripley player;
    private int rotation;

    public Dying(Actor actor) {
        rotation = actor.getAnimation().getRotation();
        player = (Ripley) actor;
        player.setName("dying ripley");
        actor.setAnimation(new Animation("resources/sprites/player_die.png", 32, 32, 100));
        actor.getAnimation().setRotation(rotation);
    }

    @Override
    public void act() {
        Input input = Input.getInstance();

        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0); //vypnutie hracieho okna.
        }

    }

}
