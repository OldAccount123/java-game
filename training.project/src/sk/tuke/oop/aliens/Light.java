package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;


public class Light extends AbstractActor implements Switchable, EnergyConsumer {
    private final Animation lightOn;
    private final Animation lightOff;
    private int reactorPower;
    private int power;
    //git
    public Light(){
        lightOn = new Animation("resources/images/light_on.png",
                    16, 16, 10);
        lightOff = new Animation("resources/images/light_off.png",
                    16, 16, 10);
        setAnimation(lightOff);
        this.power = 0;
    }
    @Override
    public void setElectricityFlow(boolean power){
       if(power == true){
           reactorPower = 1;
       }
       else{
           reactorPower = 0;
       }
       updateAnimation();
    }
    @Override
    public boolean isOn(){
        if(power == 0){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public void turnOn(){
        power = 1;
        if(reactorPower == 1 ){
             setAnimation(lightOn);
        }
    }
    @Override
    public void turnOff(){
        setAnimation(lightOff);
        power = 0;
    }
    
    public void toggle(){
        if(getPower() == 0 ){
            setPower(1);
        }
        else{
            setPower(0);
        }
        updateAnimation();
    }      
    public void updateAnimation(){
        if(reactorPower == 1 && getPower() == 1){
            setAnimation(lightOn);
        }
        else{
            setAnimation(lightOff);
        }
    }

    /**
     * @param power the power to set
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }
}
