package doublyLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {
    private MyDoublyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyDoublyLinkedList<>();
    }

    @Test
    void testAddFirst() {
        list.addFirst(10);
        list.addFirst(20);
        assertEquals(2, list.size());
        assertEquals(20, list.peekFirst());
        assertEquals(10, list.peekLast());
    }

    @Test
    void testAddLast() {
        list.addLast(5);
        list.addLast(15);
        assertEquals(2, list.size());
        assertEquals(5, list.peekFirst());
        assertEquals(15, list.peekLast());
    }

    @Test
    void testRemoveFirst() {
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(2, list.peekFirst());
    }

    @Test
    void testRemoveLast() {
        list.addLast(1);
        list.addLast(2);
        assertEquals(2, list.removeLast());
        assertEquals(1, list.size());
        assertEquals(1, list.peekFirst());
    }

    @Test
    void testAddAtIndex() {
        list.addLast(1);
        list.addLast(3);
        list.add(1, 2);
        assertEquals(3, list.size());
        assertEquals(2, list.get(1));
    }

    @Test
    void testRemoveAtIndex() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(3, list.get(1));
    }

    @Test
    void testGetAndSet() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(2, list.get(1));
        assertEquals(2, list.set(1, 42));
        assertEquals(42, list.get(1));
    }

    @Test
    void testIndexOfAndContains() {
        list.addLast(5);
        list.addLast(10);
        list.addLast(15);
        assertEquals(1, list.indexOf(10));
        assertTrue(list.contains(15));
        assertFalse(list.contains(99));
    }

    @Test
    void testClearAndIsEmpty() {
        list.addLast(1);
        list.addLast(2);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testIterator() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        int sum = 0;
        for (int val : list) {
            sum += val;
        }
        assertEquals(6, sum);
    }

    @Test
    void testRemoveFromEmpty() {
        // Verify that the correct exceptions are thrown when trying to access an empty list.
        assertThrows(NoSuchElementException.class, list::removeFirst);
        assertThrows(NoSuchElementException.class, list::removeLast);
        assertThrows(NoSuchElementException.class, list::peekFirst);
        assertThrows(NoSuchElementException.class, list::peekLast);
    }

    @Test
    void testAddNullThrows() {
        // Verify that the correct exceptions are thrown when trying to add null elements to the list.
        assertThrows(IllegalArgumentException.class, () -> list.addFirst(null));
        assertThrows(IllegalArgumentException.class, () -> list.addLast(null));
        assertThrows(IllegalArgumentException.class, () -> list.add(0, null));
        list.addLast(1);
        assertThrows(IllegalArgumentException.class, () -> list.set(0, null));
        assertThrows(IllegalArgumentException.class, () -> list.contains(null));
    }

    @Test
    void testIndexOutOfBounds() {
        // Verify that the correct exceptions are thrown when trying to access invalid indices in the list.
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 1));
    }
}

