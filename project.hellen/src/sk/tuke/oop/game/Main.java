package sk.tuke.oop.game;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;
import sk.tuke.oop.game.commands.TakeItem;

public class Main {

    public static void scenario() {
        //Ripley ripley = new Ripley();
        //Barrel barrel = new Barrel();
        //hrac znici barelly.
        //myCommand = new TakeItem(backpack, AccessCard);
        //myCommand.execute();
        //zoberie karticku
        //LockedDoor.use(AccessCard) -odomknu sa dvere
        //Lockeddoor.use(Ripley) -otvoria sa dvere
        //hrac zabije aliena
        //switch.use(Ripley);
        //hrac spusti switch, otvori sa tunel
        //tunnel.use(Ripley), Ripley prejde cez tunel a preskoci tak ohen
        //Ripley znici barrely.
        //alienEgg.use(Ripley), hrac odpali rodisko Alienov aby mohol zit.
        //myCommand = new TakeItem(backpack, AccessCard);
        //myCommand.execute();
        //Ripley pickne AccessCardu
        //LockedDoor.use(AccessCard) -odomknu sa dvere
        //Lockeddoor.use(Ripley) -otvoria sa dvere
        //Ripley otvori dvere
        //Ripley zabije AlienMother
        //computer.use(Ripley) - ripley zapne computer, ten pusti vytah
        // ripley znici barely.
        //teleport.use(Ripley) hrac pouzije teleport, ktory je zapnuty pocitacom
        //Hra sa ukonci.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SlickWorld instance = new SlickWorld("Aliens", 800, 600);
        ActorFactoryImpl actFac = new ActorFactoryImpl();
        instance.setFactory(actFac);
        instance.setMap("resources/levels/map.tmx");
        instance.run();
    }

}
