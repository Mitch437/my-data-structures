import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * My implementation of a singly linked list using a generic type.
 * Supports operations such as add, remove, insert, and reverse.
 *
 * @author Mitchell Lord.
 * @param <E> The type of data stored in the list.
 */
public class MyLinkedList<E> implements Iterable<E>{
    private Node<E> head;
    private int size;

    /**
     * Defines the node objects used to construct the linked list.
     * Stores data and a reference to the next node in the list.
     *
     * @param <E> The type of data stored in the node.
     */
    private static class Node<E> {
        public E val;
        public Node<E> next;

        /**
         * Constructs a node object with a given value and reference to the next node in the list.
         *
         * @param val The value that the node will store.
         * @param next Reference to the next node in the linked list.
         */
        public Node (E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }


        /**
         * Constructs a node object with a given value.
         * Sets the reference to the next node as null.
         *
         * @param val The value the node will store.
         */
        public Node(E val) {
            this(val, null);
        }
    }


    /**
     * Constructs a linked list object.
     * Initializes the head node to null and size to zero.
     */
    public MyLinkedList () {
        head = null;
        size = 0;
    }


    /**
     * Adds a new node with the given value to the front of the linked list.
     * Increments size of the list.
     *
     * @param value The value to be added.
     */
    public void addToFront(E value) {
        head = new Node<>(value, head);
        size++;
    }


    /**
     * Adds a new node with the given value to the back of the linked list.
     * Increments size of the list.
     *
     * @param value The value to be added.
     */
    public void append(E value) {
        if (head == null) {
            head = new Node<>(value);
            size++;
            return;
        }

        Node<E> current = head;

        while(current.next != null) {
            current = current.next;
        }

        current.next = new Node<>(value);
        size++;
    }


    /**
     * Inserts the given value at the given index in the linked list.
     * Increments the size of the list.
     *
     * @param index The index at which the new value is to be added in the list.
     * @param value The value to be added.
     */
    public void insertAt(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size);
        }

        if (index == 0) {
            addToFront(value);
            return;
        }

        if (index == size) {
            append(value);
            return;
        }

        Node<E> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = new Node<>(value, current.next);
        size++;
    }


    /**
     * Removes the first occurrence of a node with the given value from the list.
     *
     * @param value The value to be removed.
     * @return True if the value was removed, false otherwise.
     */
    public boolean remove(E value) {
        if (head == null) {
            return false;
        }

        if (head.val.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node<E> current = head;
        while (current.next != null) {
            if (current.next.val.equals(value)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes the element from the given index of the list.
     *
     * @param index The index that the value will be removed from.
     * @throws IndexOutOfBoundsException if the inputted index is invalid, i.e. less that zero or greater than or equal to the size of the list.
     */
    public void removeFrom(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size);
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        size--;
    }


    /**
     * Returns the value of the node at the given index in the list.
     *
     * @param index The index whose value will be returned.
     * @return The value from the given node's index.
     * @throws IndexOutOfBoundsException if the inputted index is invalid, i.e. less that zero or greater than or equal to the size of the list.
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size);
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }


    /**
     * Determines if the given value is contained in the list.
     *
     * @param value The value to be tested.
     * @return True if the value is in the list, and false otherwise.
     */
    public boolean contains(E value) {
        Node<E> current = head;
        while (current != null) {
            if (current.val.equals(value))
                return true;
            current = current.next;
        }
        return false;
    }


    /**
     * Returns the index of the first occurrence of a node with the given value in the list.
     *
     * @param value The value to search for.
     * @return The index of the node with the given value, or -1 if the value was not found in the list.
     */
    public int indexOf(E value) {
        if (head == null) {
            return -1;
        }

        int count = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.val.equals(value)) {
               return count;
            }
            count++;
            current = current.next;
        }

        return -1;
    }


    /**
     * Reverses the order of the nodes in the linked list using a stack.
     */
    public void reverse() {
        Stack<Node<E>> stack = new Stack<>();

        Node<E> current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        head = stack.pop();
        current = head;
        for (int i = 0; i < size - 1; i++) {
            current.next = stack.pop();
            current = current.next;
        }

        current.next = null;
    }


    /**
     * Clears all elements from the list.
     */
    public void clear() {
        head = null;
        size = 0;
    }


    /**
     * Determines if the list contains any elements.
     *
     * @return True if the list contains at least one element, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Getter method for the size attribute.
     *
     * @return An integer representing the number of elements in the list.
     */
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        if (head == null) {
            return "List is empty";
        }

        StringBuilder linkedList = new StringBuilder();

        Node<E> current = head;
        while (current != null) {
            linkedList.append(current.val);
            if (current.next != null) {
                linkedList.append(" -> ");
            }
            current = current.next;
        }

        return linkedList.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E value = current.val;
                current = current.next;
                return value;
            }
        };
    }
}
