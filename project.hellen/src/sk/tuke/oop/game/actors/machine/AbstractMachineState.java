package sk.tuke.oop.game.actors.machine;

/**
 *
 * @author Matej Gazda
 */
public abstract class AbstractMachineState {

    public AbstractMachineState floorSwitchActivated() {
        return this;
    }

    public AbstractMachineState wallSwitchActivated() {
        return this;
    }

    public AbstractMachineState leverRetracted() {
        return this;
    }

    public AbstractMachineState act() {
        return this;
    }
}
