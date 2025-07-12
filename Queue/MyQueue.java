package Queue;

import LinkedList.MyLinkedList;

import java.util.Iterator;

/**
 * My implementation on a queue using generics.
 * Follows the classic first-in first-out model.
 * Uses my implementation of a singly linked list as the backing structure.
 * Implements the Iterable interface to enable the use of enhanced for loops.
 *
 * @author Mitchell Lord.
 * @param <T> The type of data that will be stored in the queue.
 */
public class MyQueue<T> implements Iterable<T> {
    private MyLinkedList<T> queue;


    /**
     * Constructs the queue using my implementation of a singly linked list as the backing storage.
     */
    public MyQueue () {
        queue = new MyLinkedList<>();
    }


    /**
     * Adds an entry to the back of the queue.
     *
     * @param entry The entry to be added.
     */
    public void enqueue(T entry) {
        queue.append(entry);
    }


    /**
     * Removes the first entry in the queue and returns it.
     *
     * @return The first entry in the queue.
     */
    public T dequeue() {
        return queue.removeFirst();
    }


    /**
     * Returns the first entry in the queue without removing it.
     *
     * @return The value of the first entry in the queue.
     */
    public T peek() {
        return queue.peekFirst();
    }


    /**
     * Determines if the queue contains any elements.
     *
     * @return True is the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size() {
        return queue.size();
    }


    /**
     * Removes all entries from the queue.
     */
    public void clear() {
        queue.clear();
    }


    /**
     * Determines if the queue contains a specific entry.
     *
     * @param entry The value we want to know if the queue contains.
     * @return True if the entry is found in the queue, false otherwise.
     */
    public boolean contains(T entry) {
        return queue.contains(entry);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty";
        }

        StringBuilder queueData = new StringBuilder();

        for (T entry : queue) {
            queueData.append(entry).append(" <- ");
        }

        if (queueData.length() >= 4) {
            queueData.delete(queueData.length() - 4, queueData.length());
        }

        return queueData.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }
}
