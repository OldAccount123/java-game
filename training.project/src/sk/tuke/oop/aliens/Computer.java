package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Computer extends AbstractActor implements EnergyConsumer{
    private Animation compAni;
    public Computer(){
        compAni = new Animation("resources/images/computer.png",80,48,1);
        setAnimation(compAni);
        compAni.stop();
    }
    @Override
    public void setElectricityFlow(boolean reactorPower){
        if(reactorPower == false){
            compAni.stop();
        }
        else{
            compAni.start();
        }
    }
    
    public int add(int x, int y, int z){
        return (x+y+z);
    }
    public int add(int x, int y){
        return (x+y);
    }
    public int sub(int x, int y, int z){
        return (x-y-z);
    }
    public int sub(int x, int y){
        return (x-y);
    }
    public int mul(int x, int y, int z){
        return (x*y*z);
    }
    public int mul(int x, int y){
        return (x*y);
    }
    public int div(int x, int y, int z){
        return (x/y/z);
    }
    public int div(int x, int y){
        return (x/y);
    }
    public double add(double x, double y){
        return(x+y);
    }
    public double sub(double x, double y){
        return(x-y);
    }
    public double mul(double x, double y){
        return(x*y);
    }
    public double div(double x, double y){
        return(x/y);
    }
    
}
