package sk.tuke.oop.game.actors;

/**
 *
 * @author Matej Gazda
 */
public abstract class AbstractCharacter extends AbstractActor {

    private int energy;

    public AbstractCharacter(String name) {
        super(name);
    }

    public AbstractCharacter() {

    }

    /**
     * @return the health
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy the health to set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
