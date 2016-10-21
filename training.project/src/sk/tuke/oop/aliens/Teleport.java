package sk.tuke.oop.aliens;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.aliens.actor.Player;
import sk.tuke.oop.framework.Animation;

public class Teleport extends AbstractActor {
    private Teleport desTeleport;
    private Player player;
    //information about status of player, if he s ready for porting.
    private boolean status;
    private boolean out;
    private boolean in;

    public Teleport(Teleport destination) {
        Animation port = new Animation("resources/images/lift.png",48,48,50);
        setAnimation(port);
        out = false;
        this.desTeleport = destination; 
        
    }
    
    public void setDestination(Teleport desTeleport) {
        if(desTeleport != this){
            this.desTeleport = desTeleport;
        }
    }
 
    public void teleportPlayer() {
        player = getPlayer();
        int portX, portY, playerX, playerY;
        portX = this.getX();
        portY = this.getY();
        player = getPlayer();
        playerX = player.getX();
        playerY = player.getY();
        if (this.desTeleport != null && in == true &&  out == true && status == true &&playerX + 16 >= portX &&
                playerX + 16 <= portX+48 && playerY + 16 >= portY && playerY + 16 <= portY+48) {
             player.setPosition(desTeleport.getX()+8,desTeleport.getY()+8);
             desTeleport.out = false;
             desTeleport.status = false;
        }
    }
    @Override
    public void act() {
        int portX, portY, playerX, playerY;
        portX = this.getX();
        portY = this.getY();
        player = getPlayer();
        playerX = player.getX();
        playerY = player.getY();
        
        if((playerX+16 >= portX && playerX+16 <= portX+48 && playerY+16 >= portY && playerY+16 <= portY+48)==false){
            in = false;
            status = true;
        } 
        else{
            in = true;
        }
        if (in == true ){
            out = true;
        }
        
        teleportPlayer();
        
    }
    
}