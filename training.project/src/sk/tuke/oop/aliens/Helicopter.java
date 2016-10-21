package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.aliens.actor.Player;
import sk.tuke.oop.framework.Animation;

public class Helicopter extends AbstractActor {

    private boolean status;

    public Helicopter() {
        setAnimation(new Animation("resources/images/heli.png", 64, 64, 100));
        this.status = false;
    }

    public void searchAndDestroy() {
        status = true;
    }

    @Override
    public void act() {
        if (status == true) {
            //zadefinovanie pozic actorov, konkretne hraca a helikoptery, pri intersecte je damage.
            Player player = getPlayer();
            int helicopterX = this.getX();
            int helicopterY = this.getY();
            if (this.intersects(player)){
                player.setEnergy(player.getEnergy() - 1);
            }
            //to check wheter this works, still off by one.
            if (helicopterX < player.getX()) {
                helicopterX += 1;
            } else {
                helicopterX -= 1;
            }
            if (helicopterY < player.getY()) {
                helicopterY += 1;
            } else {
                helicopterY -= 1;
            }
            // ak sa stretnu, musi sa zmensit HP o 1 playerovi.
            setPosition(helicopterX, helicopterY);
        }
    }
}
