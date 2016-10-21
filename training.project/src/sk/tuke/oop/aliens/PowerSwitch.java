package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;
public class PowerSwitch extends AbstractActor {
    private Switchable device;
    public PowerSwitch(Switchable device){
        this.device = device;
        setAnimation(new Animation("resources/images/switch.png", 16, 16, 10));
    }
    public void switchOn(){
        if(device != null){
            device.turnOn();
        }
    }
    public void switchOff(){
        if(device != null){
            device.turnOff();
        }
    }
}
