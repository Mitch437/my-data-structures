package linkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class MyLinkedListTests {
    private MyLinkedList<Integer> list;

    @BeforeEach
    void setup() {
        list = new MyLinkedList<>();
    }

    @Test
    void testGet() {
        list.append(10);
        list.append(20);
        list.append(30);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1); // Verify the program correctly throws an exception when trying to get an item from an invalid index.
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1000); // Verify the program correctly throws an exception when trying to get an item from an invalid index.
        });

        Iterator<Integer> iter = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(iter.next(), list.get(i)); // Verify that get matches iterator.
        }
    }

    @Test
    void testAddToFront() {
        list.addToFront(1);

        assertEquals(1, list.get(0));

        list.addToFront(2);

        assertEquals(2, list.get(0));
        assertEquals(2, list.size()); // Verify the size updates.
    }

    @Test
    void testAppend() {
        // Populate the list.
        list.append(10);
        list.append(20);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testInsertAt() {
        // Populate the list.
        list.append(10); // Index 0.
        list.append(20); // Index 1.
        list.append(30); // Index 2.

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insertAt(-1, 0); // Verify the program correctly throws an exception when trying to insert at an invalid index.
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insertAt(1000, 0); // Verify the program correctly throws an exception when trying to insert at an invalid index.
        });

        list.insertAt(1, 15); // Middle.
        assertEquals(10, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(30, list.get(3));

        list.insertAt(0, 5); //Beginning.
        assertEquals(5, list.get(0));

        list.insertAt(list.size(), 35); // End.
        assertEquals(35, list.get(list.size() - 1));

        assertEquals(6, list.size()); // List should now contain 6 elements.
    }

    @Test
    void testRemove() {
        list.append(1);
        list.append(2);
        list.append(3);

        assertTrue(list.contains(2)); // Verify 2 was added.

        assertTrue(list.remove(2)); // Verify remove returns true when removing existing element.

        assertFalse(list.contains(2)); // Verify 2 was removed.

        assertFalse(list.remove(555)); // Verify remove returns false for elements not in the list.

        assertTrue(list.contains(1)); // Verify 1 is still present.

        assertTrue(list.remove(1)); // Remove 1 and verify return true.

        assertFalse(list.contains(1)); // Verify 1 was removed.

        assertEquals(1, list.size()); // Verify only one element remains.

        assertTrue(list.contains(3)); // Verify 3 was unaffected.
    }

    @Test
    void testRemoveFirst() {
        assertThrows(java.util.NoSuchElementException.class, () -> {
            list.removeFirst(); // Verify the program correctly throws an exception when trying to remove from an empty list.
        });

        // Populate the list.
        list.append(10);
        list.append(20);
        list.append(30);

        assertEquals(10, list.removeFirst());
        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
    }

    @Test
    void testRemoveFrom() {
        // Populate the list.
        list.append(100);
        list.append(200);
        list.append(300);

        list.removeFrom(0);
        list.removeFrom(1);

        assertFalse(list.contains(100));
        assertFalse(list.contains(300));

        assertEquals(1, list.size());

        assertTrue(list.contains(200));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeFrom(-1); // Verify the program correctly throws an exception when trying to remove from an invalid index.
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeFrom(1000); // Verify the program correctly throws an exception when trying to remove from an invalid index.
        });
    }

    @Test
    void testContains() {
        assertFalse(list.contains(0)); // Verify that contains works on an empty list.
        assertFalse(list.contains(null));

        // Populate the list.
        list.append(100);
        list.append(200);
        list.append(300);

        assertTrue(list.contains(100));
        assertTrue(list.contains(200));
        assertTrue(list.contains(300));
        assertFalse(list.contains(555)); // Verify that contains returns false when given a value that isn't in the list.
    }

    @Test
    void testIndexOf() {
        // Verify that indexOf returns -1 on an empty list.
        assertEquals(-1, list.indexOf(10));

        // Populate the list.
        list.append(10);
        list.append(20);
        list.append(30);

        assertEquals(0, list.indexOf(10));
        assertEquals(1, list.indexOf(20));
        assertEquals(2, list.indexOf(30));
        assertEquals(-1, list.indexOf(999)); // Not in list.
    }

    @Test
    void testPeekFirst() {
        // Peek first on empty list should throw NoSuchElementException.
        assertThrows(java.util.NoSuchElementException.class, () -> list.peekFirst());

        // Populate the list.
        list.append(5);
        list.append(15);

        assertEquals(5, list.peekFirst());
        assertEquals(5, list.peekFirst()); // Verify element was not removed.
    }

    @Test
    void testReverse() {
        // Reversing empty list should do nothing.
        list.reverse();
        assertTrue(list.isEmpty());

        // Populate and reverse list.
        list.append(1);
        list.append(2);
        list.append(3);
        list.reverse();

        // Now first element should be 3.
        assertEquals(3, list.peekFirst());

        // The order should be reversed: 3 -> 2 -> 1.
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    void testClear() {
        // Populate the list.
        list.append(1);
        list.append(2);
        list.append(3);

        list.clear();

        assertTrue(list.isEmpty());  // List should be empty after clear.
        assertThrows(java.util.NoSuchElementException.class, () -> list.peekFirst()); // peekFirst should throw exception on empty list.
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty()); // List is initially empty.

        // Populate the list.
        list.append(1);

        assertFalse(list.isEmpty());

        list.clear();
        assertTrue(list.isEmpty()); // Empty again after clear.
    }

    @Test
    void testSize() {
        assertEquals(0, list.size()); // Empty list should be size zero.

        // Populate the list.
        list.append(1);
        list.append(2);

        assertEquals(2, list.size());

        list.removeFirst();
        assertEquals(1, list.size());

        list.clear();
        assertEquals(0, list.size());
    }

}
