package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Cooler extends AbstractActor implements Switchable{
    private Reactor reactor;
    private int power;
    private final Animation coolerOn;
    private final Animation coolerOff;
    public Cooler(Reactor reactor){
        this.power = 0;
        this.reactor = reactor;
        this.coolerOn= 
                new Animation("resources/images/fan.png", 32,32, 200);
        this.coolerOff=
                new Animation("resources/images/fan.png", 32,32, 200);
        updateAnimation();

        
    }
    public void updateAnimation(){
        if(getPower() == 0){
            setAnimation(coolerOff);
            coolerOff.stop();
            coolerOff.setLooping(false);
        }
        else{
            coolerOn.start();
            setAnimation(coolerOn);
        }
    }
    
    @Override
    public void act(){
        if(isOn() == true && reactor != null){
            reactor.decreaseTemperature(1);
        }
    }
  
    @Override
    public boolean isOn(){
        if(getPower() == 0){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public void turnOn(){
       power = 1; 
       updateAnimation();
    }
    @Override
    public void turnOff(){
       power = 0;
       updateAnimation();
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }
}
