package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Controller extends AbstractActor{
    private Reactor myReactor;
    public Controller(Reactor reactor){
        if(reactor == null){
            return;
        }
        myReactor = reactor;
        setAnimation(new Animation("resources/images/switch.png",16,16,10));
        //rovnomenny ako nasa premenna.
    }
    public void toggle(){
        if(myReactor.isOn() == false){
            myReactor.turnOn();
        }
        else{
            myReactor.turnOff();
        }
        //lol
    }
}
