package stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyStackTest {
    private MyStack<Integer> stack;

    @BeforeEach
    void setup() {
        stack = new MyStack<>();
    }

    @Test
    void testPushPop() {
        // Populate the stack.
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty()); // Make sure pop is actually removing elements from the stack.
    }

    @Test
    void testPeek() {
        // Populate the stack.
        stack.push(14);

        assertEquals(14, stack.peek());
        assertEquals(14, stack.peek()); // To ensure peek did not remove the element.
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size()); // Stack should be empty initially.

        // Populate the stack.
        stack.push(100);
        stack.push(200);
        stack.push(300);

        assertEquals(3, stack.size());

        stack.pop();

        assertEquals(2, stack.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty()); // Stack should be initially empty.

        // Populate the stack.
        stack.push(27);

        assertFalse(stack.isEmpty());

        stack.pop();

        assertTrue(stack.isEmpty());
    }

    @Test
    void testClear() {
        // Populate the stack.
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.clear();

        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(java.util.NoSuchElementException.class, () -> {
            stack.pop(); // Verify the program correctly throws an exception when an empty stack is popped.
        });
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(java.util.NoSuchElementException.class, () -> {
            stack.peek(); // Verify the program correctly throws an exception when an empty stack is peeked.
        });
    }
}
