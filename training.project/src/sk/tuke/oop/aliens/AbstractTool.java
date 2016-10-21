package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
public abstract class AbstractTool extends AbstractActor{
    private int countAbleToUse;
    public AbstractTool(int count){
        this.countAbleToUse = count;        
    }
    public void use(){
        countAbleToUse -= 1;
        if(countAbleToUse == 0){
            getWorld().removeActor(this);
        }
    }
}
