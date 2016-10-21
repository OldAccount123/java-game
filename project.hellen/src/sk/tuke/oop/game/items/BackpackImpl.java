package sk.tuke.oop.game.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Backpack;
import sk.tuke.oop.framework.Item;

public class BackpackImpl implements Backpack {

    private int capacity, current;
    private List<Item> bpItems;

    public BackpackImpl(int capacity) {
        bpItems = new ArrayList<>(capacity - 1);
        this.capacity = capacity;
        current = 0;
    }

    @Override
    public void add(Item item) {
        int cursor;
        if (getBpItems().size() >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            getBpItems().add(0, item);
        }
    }

    @Override
    public void remove(Item item) {
        if (bpItems.contains(item)) {
            getBpItems().remove(item);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return this.getBpItems().iterator();
    }

    public Item getLastItem() {
        if (!bpItems.isEmpty()) {
            return getBpItems().get(0);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Checks whether is the backpack empty or not.
     *
     * @return true/false
     */
    public boolean isEmpty() {
        return getBpItems().isEmpty();
    }

    /**
     * @return the bpItems
     */
    public List<Item> getBpItems() {
        return bpItems;
    }

}
