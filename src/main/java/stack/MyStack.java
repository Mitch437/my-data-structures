package stack;

import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 * Generic stack implementation backed by a resizable array.
 *
 * @author Mitchell Lord.
 * @param <E> Generic data type stored in the stack.
 */
public class MyStack<E> {
    private E[] data;
    private int size;


    /**
     * Constructs the stack using an empty array of size 20.
     */
    @SuppressWarnings("unchecked")
    public MyStack () {
        data = (E[]) new Object[2];
        size = 0;
    }


    /**
     * Adds an entry to the top of the stack.
     * @param entry The entry to be added.
     */
    public void push(E entry) {
        if (size == data.length) {
            resize();
        }

        data[size++] = entry;
    }


    /**
     * Removes the entry on top of the stack and returns it.
     *
     * @return The entry that was removed from the top of the stack.
     */
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        E entry = data[--size];
        data[size] = null;

        return entry;
    }


    /**
     * Return the entry on top of the stack without removing it.
     *
     * @return The entry on top of the stack.
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        return data[size - 1];
    }


    /**
     * Gets the size of the stack.
     *
     * @return The number of entries in the stack.
     */
    public int size() {
        return size;
    }


    /**
     * Determines if the stack is empty or not.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Deletes all entries from the stack.
     */
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }


    /**
     * Doubles the size of the backing array in the event that it is filled.
     */
    @SuppressWarnings("unchecked")
    public void resize() {
        E[] newArray = (E[]) new Object[data.length * 2];

        System.arraycopy(data, 0, newArray, 0, data.length);

        data = newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size)); // Only display occupied spaces.
    }
}
