package sk.tuke.oop.aliens;

public class SmartCooler extends Cooler {
    private final Reactor reactor;
    public SmartCooler(Reactor reactor){
        super(reactor);
        this.reactor = reactor;
    }
    
    @Override
    public void act()
    {
        if (isOn() && reactor.getDamage() < 100)
            reactor.decreaseTemperature(1);
       
        if (reactor.getTemperature() <= 1000)
            turnOff();
       
        if (reactor.getTemperature() >= 2000)
            turnOn();
    }
}
