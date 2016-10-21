package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Reactor extends AbstractActor implements Switchable, Repairable{
    private String manufacter;
    private int yearOfProduction;
    private int power;
    private int temperature;
    private int damage;
    private int newDamage;
    private final Animation normalAnimation;
    private final Animation hotAnimation;
    private final Animation deadReactor;
    private final Animation reactorOff;
    private EnergyConsumer device;
    public Reactor(String manufacter, int yearOfProduction){
        this.manufacter = manufacter;
        this.yearOfProduction = yearOfProduction;
        this.power = 0;
        this.normalAnimation = new Animation("resources/images/reactor_on.png",
                    80, 80, 100);
        this.hotAnimation = new Animation("resources/images/reactor_hot.png",
                    80, 80, 50);
        this.deadReactor = new Animation("resources/images/reactor_broken.png",
                    80, 80, 100);
        this.reactorOff = new Animation("resources/images/reactor.png",
                    80, 80, 100);
        this.temperature = 0;
        this.damage = 0;
        
        deadReactor.setPingPong(true);
        hotAnimation.setPingPong(true);
        normalAnimation.setPingPong(true);
        setAnimation(reactorOff);
    }
    public void increaseTemperature(int increment){
        if(increment < 0 || damage >= 100 | getPower() == 0 || temperature >= 5000){
            return;
        }
        temperature += increment;
        // if the reactor health is lower than 50%, then the temperature 
        // increases twice as much.
        if(damage > 50){
            temperature += increment;
        }
        newDamage = ((temperature - 2000) / 30);
        //the cooling doesnt affect the damage of the reactor, thus cooling him
        // wont repair him.
        if(newDamage > damage && damage < 100){
            damage = newDamage;
        }
        if(damage > 100){
            damage = 100;
        }
        updateAnimation();
    }
    public void decreaseTemperature(int decrement){
        if(decrement < 0 || damage >= 100 || getPower() == 0 || temperature == 0){
            return;
        }
        if(damage < 50){
            temperature -= decrement;
        }
        else{
            temperature -= (decrement/2);
        }   
        updateAnimation();
    }
    /**
     *This function updates the reactor animation on the basis of the damage
     *done by the player. If the damage is higher than 100%, the reactor is 
     *destroyed and animation is reactor_broken.png, if the damage dealt is lower
     *than 100 and higher then 66,66%, then the animation is reactor_hot.png and
     *when the damage is lower than 66,66% the animation is the same as on start.
    */
    private void updateAnimation(){
        if(getPower() == 0 && temperature < 5000){
            setAnimation(reactorOff);
        }
        else if(getPower() == 1 && temperature < 4000){
            setAnimation(normalAnimation);
        }
        else if(temperature > 4999){
            power = 0;
            setAnimation(deadReactor);
            if(device != null){
                device.setElectricityFlow(false);
            }
            
        }
        else if(temperature > 4000){
            setAnimation(hotAnimation);
            hotAnimation.setDuration(damage);
        }
        
  }
    /**
     * This function returns boolean type. True if the service is needed
     * that means temperature > 3000 and damage > 50% if not, returns false.
     */
    public boolean isServiceNeeded(){
        if(damage > 50 && temperature > 3000){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * if there is reference to the hammer type, then the reactor is repaired. 
     * @param kladivo 
     */
    @Override
    public void repair(AbstractTool kladivo){
        if(kladivo instanceof Hammer){
            newDamage = damage - 50;
            if(kladivo == null || damage >= 100){
                return;
            }      
            if(temperature > 2000){
                damage -= 50;
                temperature = (newDamage * 30) + 2000;
            }
            if(damage < 0){
                damage = 0;
            }
            if(temperature < 0){
                temperature = 0;
            }
            kladivo.use();
            updateAnimation();
        }
    }
    /**
    this function turns the reactor on.
    */
    @Override
    public void turnOn(){
        power = 1; 
        updateAnimation();
        if(device != null){
           device.setElectricityFlow(true);
        }
    }
    /**
     * this function turns the reactor off.
     */
    @Override
    public void turnOff(){
        power = 0;
        updateAnimation();
        if(device != null){
            device.setElectricityFlow(false);
        }

    }
    /**
     * Checks whether the power of the reactor is off / on.
     * @return 
     */
    @Override
    public boolean isOn(){
        if(getPower() == 0){
            return false ;
        }
        else{
            return true;
        }
    }
    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }
    /**
     * @return the temperature
     */
    public int getTemperature() {
        return temperature;
    } 
    public void addDevice(EnergyConsumer device){
       if(device != null && this.device != device){
           this.device = device;
           if(isOn() == true){
               device.setElectricityFlow(true);
           }
           else{
               device.setElectricityFlow(false);
           }
       }
       
    }
    public void removeDevice(EnergyConsumer device){
        device.setElectricityFlow(false);
        if(this.device != null){
            this.device = null;
        }
    }
    @Override
    public void act(){
        increaseTemperature(1);
        updateAnimation();
    }

    /**
     * @return the manufacter
     */
    public String getManufacter() {
        return manufacter;
    }

    /**
     * @return the yearOfProduction
     */
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }
    
}