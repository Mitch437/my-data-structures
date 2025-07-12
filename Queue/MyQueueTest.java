package Queue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyQueueTest {
    private MyQueue<Integer> queue;

    @BeforeEach
    void setup() {
        queue = new MyQueue<>();
    }

    @Test
    void testEnqueueDequeue() {
        // Populate the queue.
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());

        assertTrue(queue.isEmpty()); // Queue should be empty after removing two entries.
    }

    @Test
    void testPeek() {
        // Populate the queue.
        queue.enqueue(5);

        assertEquals(5, queue.peek());
        assertEquals(5, queue.peek());  // To ensure peek did not remove the element.
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty()); // Queue should be initially empty.

        // Populate the queue.
        queue.enqueue(1);

        assertFalse(queue.isEmpty());
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size()); // Queue should be initially empty.

        // Populate the queue.
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.size());
    }

    @Test
    void testClear() {
        // Populate the queue.
        queue.enqueue(1);
        queue.enqueue(2);

        queue.clear();

        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueEmptyQueue() {
        assertThrows(java.util.NoSuchElementException.class, () -> {
            queue.dequeue(); // Verify the program correctly throws an exception when an empty queue is dequeued.
        });
    }

    @Test
    void testPeekEmptyQueue() {
        assertThrows(java.util.NoSuchElementException.class, () -> {
            queue.peek(); // Verify the program correctly throws an exception when an empty queue is peeked.
        });
    }
}
