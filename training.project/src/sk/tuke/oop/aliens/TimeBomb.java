package sk.tuke.oop.aliens;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.aliens.actor.AbstractActor;

public class TimeBomb extends AbstractActor{
    private int time;
    private final Animation bombActivated;
    private final Animation explosion =
                   new Animation("resources/images/small_explosion.png", 16,16,5);
    public TimeBomb(int time){
        Animation bombOff;
        this.time = time;
        bombOff = new Animation("resources/images/bomb.png", 16,16,1);
        bombActivated = 
                new Animation("resources/images/bomb_activated.png", 16,16,1);
        setAnimation(bombOff);
    }
    public void activate(){
        setAnimation(bombActivated);
    }
    @Override
    public void act(){
        if(getAnimation() == bombActivated){
            time--;
            time--;
            if(time < 0 && time  <-5){
                setAnimation(explosion);

            }
            
        }
        if(time < -5){
                getWorld().removeActor(this);
        }
    }
}
