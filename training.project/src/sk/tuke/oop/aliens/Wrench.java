package sk.tuke.oop.aliens;
import sk.tuke.oop.framework.Animation;
public class Wrench extends AbstractTool{
    public Wrench(){
        super(2);
        setAnimation(new Animation("resources/images/wrench.png", 16,16,100));
    }
}
