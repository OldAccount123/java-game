package sk.tuke.oop.aliens;
import java.util.Random;

//package sk.tuke.oop.aliens;
public class DefectiveLight extends Light implements Repairable {
    private int i = 0;
    @Override
    public void act(){
        if(i > 0){
            i--;
        }
        else{
           Random random;
           random = new Random();
           int randomNum = random.nextInt(21);
           if(randomNum == 1){
               toggle();
           }
           else{
               toggle();
           }
        } 
    }
    @Override
    public void repair(AbstractTool tool){
        if(tool instanceof Wrench){
            i = 1000;
            tool.use();
        }
    }
}

