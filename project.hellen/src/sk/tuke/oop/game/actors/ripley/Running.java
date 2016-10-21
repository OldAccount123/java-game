package sk.tuke.oop.game.actors.ripley;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.commands.NextItem;
import sk.tuke.oop.game.commands.TakeItem;
import sk.tuke.oop.game.commands.Use;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.Body;
import sk.tuke.oop.game.actors.Cooler;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.commands.Command;
import sk.tuke.oop.game.commands.Shoot;
import sk.tuke.oop.game.items.AccessCard;

public class Running implements RipleyState {

    private Ripley player;
    private Command myCommand;
    private Animation playerAnim;
    private BackpackImpl backpack;
    private Shoot strela;
    private Cooler cooler;
    private Door dvere;

    public Running(Actor actor) {
        player = (Ripley) actor;
        playerAnim = player.getAnimation();
        backpack = player.getBackpack();
        player.setName("ripley");
    }

    @Override
    public void act() {
        int step = 1;
        playerAnim.stop();
        Input input = Input.getInstance();

        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0); //vypnutie hracieho okna.
        }
        /* pohyb do hora a sucasne riesi aj pohyb po hlavnej a 
        vedlajsej diagonale do hora */
        if (input.isKeyPressed(Input.Key.UP) || input.isKeyDown(Input.Key.UP)) {
            myCommand = new Move(player, step, 0, -1);
            if (input.isKeyPressed(Input.Key.RIGHT) || input.isKeyDown(Input.Key.RIGHT)) {
                myCommand = new Move(player, step, 1, -1);
            } else if (input.isKeyPressed(Input.Key.LEFT) || input.isKeyDown(Input.Key.LEFT)) {
                myCommand = new Move(player, step, -1, -1);
            }
            myCommand.execute();
        } //pohyb dole a sucasne po diagonalach
        else if (input.isKeyPressed(Input.Key.DOWN) || input.isKeyDown(Input.Key.DOWN)) {
            myCommand = new Move(player, step, 0, 1);
            if (input.isKeyPressed(Input.Key.RIGHT) || input.isKeyDown(Input.Key.RIGHT)) {
                myCommand = new Move(player, step, 1, 1);
            } else if (input.isKeyPressed(Input.Key.LEFT) || input.isKeyDown(Input.Key.LEFT)) {
                myCommand = new Move(player, step, -1, 1);
            }
            myCommand.execute();
        } //pohyb do lava a sucasne po diagonalach
        else if (input.isKeyPressed(Input.Key.LEFT) || input.isKeyDown(Input.Key.LEFT)) {
            myCommand = new Move(player, step, -1, 0);
            if (input.isKeyPressed(Input.Key.UP) || input.isKeyDown(Input.Key.UP)) {
                myCommand = new Move(player, step, -1, -1);
            } else if (input.isKeyPressed(Input.Key.DOWN) || input.isKeyDown(Input.Key.DOWN)) {
                myCommand = new Move(player, step, -1, 1);
            }
            myCommand.execute();
        } //pohyb do prava a sucasne po diagonalach
        else if (input.isKeyPressed(Input.Key.RIGHT) || input.isKeyDown(Input.Key.RIGHT)) {
            myCommand = new Move(player, step, 1, 0);
            if (input.isKeyPressed(Input.Key.UP) || input.isKeyDown(Input.Key.UP)) {
                myCommand = new Move(player, step, 1, -1);
            } else if (input.isKeyPressed(Input.Key.DOWN) || input.isKeyDown(Input.Key.DOWN)) {
                myCommand = new Move(player, step, 1, 1);
            }
            myCommand.execute();
        }
        /*pouzitie itemu (najprv skontroluje ci nie je posledny item v backpacku
        pouzitelny, a ak nie je pouzije item, s ktorym prave intersectuje.
         */
        if (input.isKeyPressed(Input.Key.E)) {
            Use itemUse;
            Actor item;
            Actor tempActor2;
            List<Actor> tempActors = new ArrayList<>();
            for (Actor actor : player.getWorld()) {
                tempActors.add(actor);
            }
            for (Actor tempActor : tempActors) {
                if (tempActor instanceof Usable && tempActor.intersects(player) && !(tempActor instanceof AccessCard)) {
                    item = tempActor;
                    if (!backpack.isEmpty()) {
                        if (backpack.getLastItem() instanceof Usable && !(backpack.getLastItem() instanceof AccessCard)) {
                            myCommand = new Use(item, backpack.getLastItem());
                            myCommand.execute();
                        } else {
                            myCommand = new Use(item, player);
                            myCommand.execute();
                        }
                        if (backpack.getLastItem() instanceof Usable && backpack.getLastItem() instanceof AccessCard) {
                            myCommand = new Use(item, backpack.getLastItem());
                            myCommand.execute();
                        }
                    } else {
                        myCommand = new Use(item, player);
                        myCommand.execute();
                    }
                }
            }
        }
        //dropne item
        if (input.isKeyPressed(Input.Key.BACK)) {
            if (backpack.isEmpty() == false) {
                myCommand = new DropItem(backpack, player.getWorld(), player.getX(), player.getY());
                myCommand.execute();
            }
        }
        //rotacia itemov v inventari
        if (input.isKeyPressed(Input.Key.N)) {
            myCommand = new NextItem(backpack);
            myCommand.execute();
        }
        //picknutie itemu
        if (input.isKeyPressed(Input.Key.ENTER)) {
            for (Actor actor : player.getWorld()) {
                if (actor instanceof Item && player.intersects(actor)) {
                    myCommand = new TakeItem(backpack, (Item) actor);
                    myCommand.execute();
                    break;
                }
            }
        }
        //pouzitie 'body';
        if (input.isKeyPressed(Input.Key.F)) {
            List<Actor> tempActors = new ArrayList<>();
            for (Actor actor : player.getWorld()) {
                tempActors.add(actor);
            }
            for (Actor actor : tempActors) {
                if (actor instanceof Body && player.intersects(actor)) {
                    Body body = (Body) actor;
                    while (body.getBackpack().isEmpty() != true) {
                        myCommand = new DropItem(body.getBackpack(),
                                body.getWorld(), player.getX(), player.getY());
                        myCommand.execute();
                    }
                }
            }
        }
        if (input.isKeyPressed(Input.Key.SPACE)) {
            if (player.getAmmo() > 0) {
                strela = new Shoot(player);
                strela.execute();
                player.setAmmo(player.getAmmo() - 1);
            }
        }
        System.out.println(player.getAmmo());
    }
}
