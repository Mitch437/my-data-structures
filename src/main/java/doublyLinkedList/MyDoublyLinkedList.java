package doublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * My implementation of a doubly linked list using generics.
 * Supports both forward and backward iteration through the list.
 * Provides O(1) time complexity for adding or removing elements at the head or tail.
 *
 * @author Mitchell Lord.
 * @param <E> The type of data stored in the list.
 */
public class MyDoublyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;


    /**
     * Defines the node objects used to construct the list.
     * Stores data and references to the previous and next nodes of the list.
     *
     * @param <E> The type of data stored in the node.
     */
    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> previous;

        /**
         * Constructs a node object with a given value.
         *
         * @param val The value that the node will store.
         */
        Node (E val) {
            this.val = val;
        }
    }


    /**
     * Constructs the doubly linked list.
     * Set the head and tail attributes to null and the size to zero.
     */
    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * Adds an element to the beginning of the list.
     *
     * @param element The element to be added to the front.
     *
     * @throws IllegalArgumentException If the input is null.
     */
    public void addFirst(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot add a null element to the list");
        }

        Node<E> newHead = new Node<>(element);

        if (head == null) {
            head = newHead;
            tail = newHead;
        } else {
            newHead.next = head;
            head.previous = newHead;
            head = newHead;
        }

        size++;
    }


    /**
     * Adds an element to the end of the list.
     *
     * @param element The element to be added to the back.
     *
     * @throws IllegalArgumentException If the input is null.
     */
    public void addLast(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot add a null element to the list");
        }

        Node<E> newTail = new Node<>(element);

        if (tail == null) {
            head = newTail;
            tail = newTail;
        } else {
            tail.next = newTail;
            newTail.previous = tail;
            tail = newTail;
        }

        size++;
    }


    /**
     * Removes the element at the beginning of the list.
     *
     * @return The value of the removed element.
     *
     * @throws NoSuchElementException If the list is empty.
     */
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        E value = head.val;

        if (size == 1) {
            head = tail = null;
            size--;
            return value;
        }

        head = head.next;
        head.previous = null;
        size--;
        return value;
    }


    /**
     * Removes the element at the end of the list.
     *
     * @return The value of the removed element.
     *
     * @throws NoSuchElementException If the list is empty.
     */
    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        E value = tail.val;

        if (size == 1) {
            tail = head = null;
            size--;
            return value;
        }

        tail = tail.previous;
        tail.next = null;
        size--;
        return value;
    }


    /**
     * Returns the value of the element at the beginning of the list, but does not delete it.
     *
     * @return The value of the element at the beginning of the list.
     *
     * @throws NoSuchElementException If the list is empty.
     */
    public E peekFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        return head.val;
    }


    /**
     * Returns the value of the element at the end of the list, but does not delete it.
     *
     * @return The value of the element at the end of the list.
     *
     * @throws NoSuchElementException If the list is empty.
     */
    public E peekLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        return tail.val;
    }


    /**
     * Adds element to the specified index in the list.
     *
     * @param index The index where the new element will be inserted.
     * @param element The new element to be inserted.
     *
     * @throws IllegalArgumentException If the input is null.
     * @throws IndexOutOfBoundsException If the input index is negative or greater than the size of the list.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " for list of size " + size);
        }

        if (element == null) {
            throw new IllegalArgumentException("Cannot add a null element to the list");
        }

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size) {
            addLast(element);
            return;
        }

        Node<E> newNode = new Node<>(element);
        Node<E> current = getNode(index);

        newNode.previous = current.previous;
        newNode.next = current;
        current.previous.next = newNode;
        current.previous = newNode;

        size++;
    }


    /**
     * Removes and returns the element at the given index from the list.
     *
     * @param index The index of the element to be removed.
     * @return The value of the removed element.
     *
     * @throws IndexOutOfBoundsException If the input index is negative or greater or equal to the size of the list.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " for list of size " + size);
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<E> target = getNode(index);

        E value = target.val;

        target.previous.next = target.next;
        target.next.previous = target.previous;
        size--;
        return value;
    }


    /**
     * Returns the value of the element at the given index.
     *
     * @param index The index of the element to be returned.
     * @return The value of the element at the specified index.
     *
     * @throws IndexOutOfBoundsException If the input index is negative or greater or equal to the size of the list.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " for list of size " + size);
        }

        if (index == 0) {
            return peekFirst();
        }

        if (index == size - 1) {
            return peekLast();
        }

        Node<E> target = getNode(index);

        return target.val;
    }


    /**
     * Replaces the value of the element at the given index with the specified value.
     *
     * @param index The index of the element to be modified.
     * @param element The new value the element at that index will take on.
     * @return The old value of the modified element.
     *
     * @throws IllegalArgumentException If the input is null.
     * @throws IndexOutOfBoundsException If the input index is negative or greater or equal to the size of the list.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " for list of size " + size);
        }

        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Node<E> target = getNode(index);

        E value = target.val;

        target.val = element;

        return value;
    }


    /**
     * Returns the index of the given element in the list.
     *
     * @param element The element to be searched for in the list.
     * @return The index of the element if found within the list, -1 otherwise.
     *
     * @throws IllegalArgumentException If the input is null.
     */
    public int indexOf(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.val.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }


    /**
     * Determines if the given value is contained within the list.
     *
     * @param element The element to be searched for in the list.
     * @return True if the element was found in the list, false otherwise.
     *
     * @throws IllegalArgumentException If the input is null.
     */
    public boolean contains(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Node<E> current = head;

        while (current != null) {
            if (current.val.equals(element)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }


    /**
     * Determines if the list contains any elements.
     *
     * @return True if the list contains one or more elements, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Erases all elements from the list and resets the size to zero.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }


    /**
     * Helper method used to iterate to a certain index in the list and return its value.
     * If the given index is closer to the beginning of the list, the iteration starts at the head.
     * If the given index is closer to the end of the list, the iteration starts at the tail.
     *
     * @param index The index of the element to be returned.
     * @return The element found at the given index.
     */
    private Node<E> getNode(int index) {
        if (index < size / 2) {
            Node<E> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current;
        } else {
            Node<E> current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }

            return current;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "List is empty";
        }

        StringBuilder sb = new StringBuilder();

        Node<E> current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }

        return sb.toString();
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
