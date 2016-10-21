package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Cooler;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.items.BackpackImpl;
import sk.tuke.oop.game.commands.Command;

public class Ripley extends AbstractCharacter implements Movable {

    private int energy, ammo;
    private final Animation player;
    private Command myCommand;
    private RipleyState ripleyState;
    private BackpackImpl backpack;
    private String name;

    public Ripley() {
        player = new Animation("resources/sprites/player.png", 32, 32);
        this.setAnimation(player);
        energy = 100;
        ammo = 40;
        backpack = new BackpackImpl(5);
    }

    public Ripley(String name) {
        super(name);
        player = new Animation("resources/sprites/player.png", 32, 32);
        this.setAnimation(player);
        energy = 100;
        ammo = 40;
        backpack = new BackpackImpl(5);
    }

    @Override
    public void act() {
        Cooler cooler = null;
        Door dvere = null;
        if (energy > 0) {
            ripleyState = new Running(this);
            ripleyState.act();
            //ak ripleyova zomrie, zmeni sa jej animacia.
            /*tento odstavec zabezpeci 
            uberanie HP Ripleyovej ak su otvorene dvere 
            && ventilator je vypnuty*/
            if (getWorld() != null) {
                for (Actor actor : getWorld()) {
                    if (actor instanceof Cooler) {
                        cooler = (Cooler) actor;
                    } else if (actor instanceof Door) {
                        dvere = (Door) actor;
                    }
                }
                if (cooler != null && dvere != null) {
                    if (cooler.getState() == false && dvere.isOpen() == true && getEnergy() != 0) {
                        setEnergy(getEnergy() - 1);
                    }
                }
            }
        } else {
            ripleyState = new Dying(this);
            ripleyState.act();
        }
        getWorld().showBackpack(getBackpack());
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        world.showBackpack(getBackpack());
        world.centerOn(this);
    }

    /**
     * @return the ammo
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * @param ammo the ammo to set
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    /**
     * @return the backpack
     */
    public BackpackImpl getBackpack() {
        return backpack;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Item getItemByName(String name) {
        for (Actor actor : getWorld()) {
            if (name.equalsIgnoreCase(actor.getName())) {
                return (Item) actor;
            }
        }
        for (Item item : backpack) {
            if (name.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(int val) {
        energy = val;
    }
}
