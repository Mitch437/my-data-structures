package stack;

/**
 * Class used to test the 'MyStack' class.
 *
 * @author Mitchell Lord.
 */
public class MyStackTest {
    /**
     * Main method used to run various tests on the MyStack class.
     * @param args command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        testPush();
        System.out.println("===================================================================\n");

        testPop();
        System.out.println("===================================================================\n");

        testPeek();
        System.out.println("===================================================================\n");

        testClear();
        System.out.println("===================================================================\n");

        testSize();
        System.out.println("===================================================================\n");

        testIsEmpty();
        System.out.println("===================================================================\n");
    }


    /**
     * Tests the push method of MyStack.
     * Push adds elements to the top of the stack.
     */
    public static void testPush() {
        System.out.println("Push:\n");

        MyStack<Integer> stack = new MyStack<>();

        System.out.println("Test: push three entries to the top of the stack\n");

        // Displays what the stack looks like before the test.
        System.out.println("Before test:");
        System.out.println(stack.toString() + "\n");

        // Populate the stack.
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Expected vs actual output.
        String expected = "[1, 2, 3]";
        String actual = stack.toString();

        // Format and display the results of the test.
        printResults(expected, actual);
    }


    /**
     * Tests the pop method of MyStack.
     * Pop removes the element from the top of the stack and returns it.
     */
    public static void testPop() {
        System.out.println("Pop:\n");

        System.out.println("Test: pop an item from the top of the stack and store it in a variable\n");

        MyStack<Character> stack = new MyStack<>();

        // Populate the stack.
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        // Displays what the stack looks like before the test.
        System.out.println("Before test:");
        System.out.println(stack.toString() + "\n");

        // Remove and store the entry from the top of the stack.
        char actualStoredValue = stack.pop();

        System.out.println("After pop:");

        // Expected vs actual output.
        String expected = "[a, b, c]";
        String actual = stack.toString();

        char expectedStoredValue = 'd';

        System.out.println("Expected stack:");
        System.out.println(expected);
        System.out.println("Actual stack:");
        System.out.println(actual);

        System.out.println("Expected stored value:");
        System.out.println(expectedStoredValue);
        System.out.println(actualStoredValue);

        System.out.println(expected.equals(actual) && expectedStoredValue == actualStoredValue ? "PASS\n" : "FAIL\n");
    }


    /**
     * Tests the peek method of MyStack.
     * Peek returns the element from the top of the stack without removing it.
     */
    public static void testPeek() {
        System.out.println("Peek:\n");

        System.out.println("Test: peek an item from the top of the stack, store it in a variable, \n " +
                "and make sure it was not removed from the top of the stack\n");

        MyStack<String> stack = new MyStack<>();

        // Populate the stack.
        stack.push("la");
        stack.push("di");
        stack.push("da");

        // Displays what the stack looks like before the test.
        System.out.println("Before test:");
        System.out.println(stack.toString() + "\n");

        // Store the value from the top of the stack.
        String peekValue = stack.peek();

        // Expected vs actual output.
        String expected = "[la, di, da]";
        String actual = stack.toString();

        String expectedPeekValue = "da";

        System.out.println("After peek:");
        System.out.println("Expected:");
        System.out.println(expected);
        System.out.println("Actual");
        System.out.println(actual);

        System.out.println("Expected peek value:");
        System.out.println(expectedPeekValue);
        System.out.println("Actual peek value:");
        System.out.println(peekValue);

        System.out.println(expected.equals(actual) && expectedPeekValue.equals(peekValue) ? "PASS\n" : "FAIL\n");
    }


    /**
     * Tests the clear method of MyStack.
     * Clear removes all elements from the stack.
     */
    public static void testClear() {
        System.out.println("Clear:\n");

        System.out.println("Test: push elements to the stack then clear them\n");

        MyStack<Double> stack = new MyStack<>();

        // Populate the stack.
        stack.push(1.1);
        stack.push(2.2);
        stack.push(3.3);

        // Displays what the stack looks like before the test.
        System.out.println("Before test:");
        System.out.println(stack.toString() + "\n");

        // Clear all entries from the stack.
        stack.clear();

        // Expected vs actual output.
        String expected = "[]";
        String actual = stack.toString();

        printResults(expected, actual);
    }


    /**
     * Tests the size method of MyStack.
     * Size returns the number of elements in the stack.
     */
    public static void testSize() {
        System.out.println("Size:\n");

        System.out.println("Test: get size of the stack after adding and removing elements\n");

        MyStack<Integer> stack = new MyStack<>();

        // Displays what the stack looks like before the test.
        System.out.println("Initial stack:");
        System.out.println(stack.toString());

        // Expected vs actual output.
        int expectedSize = 0;
        int actualSize = stack.size();

        System.out.println("Expected size:");
        System.out.println(expectedSize);
        System.out.println("Actual size:");
        System.out.println(actualSize);

        System.out.println(expectedSize == actualSize ? "TEST 1: PASS\n" : "TEST 1: FAIL\n");

        // Populate the stack.
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after adding elements:");
        System.out.println(stack.toString() + "\n");

        expectedSize = 3;
        actualSize = stack.size();

        System.out.println("Expected size:");
        System.out.println(expectedSize);
        System.out.println("Actual size:");
        System.out.println(actualSize);

        System.out.println(expectedSize == actualSize ? "TEST 2: PASS\n" : "TEST 2: FAIL\n");

        stack.pop();
        stack.pop();

        System.out.println("Stack after popping two elements:");
        System.out.println(stack.toString());

        expectedSize = 1;
        actualSize = stack.size();

        System.out.println("Expected size:");
        System.out.println(expectedSize);
        System.out.println("Actual size:");
        System.out.println(actualSize);

        System.out.println(expectedSize == actualSize ? "TEST 3: PASS\n" : "TEST 3: FAIL\n");
    }

    /**
     * Tests the isEmpty method of MyStack.
     * IsEmpty returns true if the stack has no elements and false otherwise.
     */
    public static void testIsEmpty() {
        System.out.println("IsEmpty:\n");

        System.out.println("Test: check if the stack is empty after adding and removing elements\n");

        MyStack<Integer> stack = new MyStack<>();

        // Displays what the stack looks like before the test.
        System.out.println("Initial stack:");
        System.out.println(stack.toString());

        // Expected vs actual output.
        boolean expected = true;
        boolean actual = stack.isEmpty();

        System.out.println("Expected:");
        System.out.println(expected);
        System.out.println("Actual:");
        System.out.println(actual);
        System.out.println(expected == actual ? "TEST 1: PASS\n" : "TEST 1: FAIL\n");

        // Populate the stack.
        stack.push(-1);
        stack.push(0);
        stack.push(1);

        System.out.println("Stack after pushing elements:");
        System.out.println(stack.toString());

        expected = false;
        actual = stack.isEmpty();

        System.out.println("Expected:");
        System.out.println(expected);
        System.out.println("Actual:");
        System.out.println(actual);
        System.out.println(expected == actual ? "TEST 2: PASS\n" : "TEST 2: FAIL\n");

        stack.clear();

        System.out.println("Stack after clearing:");
        System.out.println(stack.toString());

        expected = true;
        actual = stack.isEmpty();

        System.out.println("Expected:");
        System.out.println(expected);
        System.out.println("Actual:");
        System.out.println(actual);
        System.out.println(expected == actual ? "TEST 3: PASS\n" : "TEST 3: FAIL \n");
    }


    /**
     * Helper method used to print the results of a test.
     * @param expected The expected output.
     * @param actual The actual output.
     */
    public static void printResults(String expected, String actual) {
        System.out.println("After test:");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println(expected.equals(actual) ? "PASS\n" : "FAIL\n");
    }
}
