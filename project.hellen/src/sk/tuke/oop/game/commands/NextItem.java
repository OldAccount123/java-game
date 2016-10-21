package sk.tuke.oop.game.commands;

import java.util.Collections;
import sk.tuke.oop.game.items.BackpackImpl;

public class NextItem implements Command {

    private final BackpackImpl backpack;

    public NextItem(BackpackImpl backpack) {
        this.backpack = backpack;
    }

    @Override
    public void execute() {
        int i;
        if (backpack.getBpItems().size() >= 2) {
            for (i = 0; i != backpack.getBpItems().size() - 2; i++) {
                Collections.swap(backpack.getBpItems(), i, i + 1);
            }
        }
    }
}
