    package sk.tuke.oop.aliens;
    import sk.tuke.oop.framework.Animation;

    public class Hammer extends AbstractTool {
        
        //blahblah
        public Hammer(){
            super(1);
            setAnimation(new Animation("resources/images/hammer.png", 16,16,10));
        }
        public Hammer(int i){
            super(i);
            setAnimation(new Animation("resources/images/hammer.png", 16,16,10));
        }
    }
