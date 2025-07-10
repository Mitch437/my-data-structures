/**
 * Class used to test the 'MyLinkedList' class.
 *
 * @author Mitchell Lord.
 */
public class MyLinkedListTests {
    /**
     * Main method used to run various tests on the MyLinkedList class.
     * @param args command line arguments, not used in this program.
     */
    public static void main(String[] args) {
        testAppend();
        System.out.println("===================================================================\n");

        testRemove();
        System.out.println("===================================================================\n");

        testAddToFront();
        System.out.println("===================================================================\n");

        testInsertAt();
        System.out.println("===================================================================\n");

        testRemoveFrom();
        System.out.println("===================================================================\n");

        testGet();
        System.out.println("===================================================================\n");

        testContains();
        System.out.println("===================================================================\n");

        testIndexOf();
        System.out.println("===================================================================\n");

        testReverse();
        System.out.println("===================================================================\n");

        testClear();
        System.out.println("===================================================================\n");

        testIsEmpty();
        System.out.println("===================================================================\n");

        testSize();
        System.out.println("===================================================================\n");

        testIterator();
        System.out.println("===================================================================\n");
    }


    /**
     * Tests the append method of the MyLinkedList class.
     * Append adds an element to the end of the list.
     */
    public static void testAppend() {
        System.out.println("Append:\n");

        // Description of test.
        System.out.println("Test: add elements to the end of the list\n");

        // Linked list of integers.
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        // Add data to the end of the linked list.
        list.append(1);
        list.append(2);
        list.append(3);

        String expected = "1 -> 2 -> 3"; // What the output should be.
        String actual = list.toString(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the remove method of the MyLinkedList class.
     * Remove deletes an element of the list given its value.
     */
    public static void testRemove() {
        System.out.println("Remove:\n");

        // Description of test.
        System.out.println("Test: remove 2.1 from the list\n");

        // Linked list of doubles.
        MyLinkedList<Double> list = new MyLinkedList<>();

        // Populate the list.
        list.append(1.1);
        list.append(2.1);
        list.append(3.1);

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        // Remove element.
        list.remove(2.1);

        String expected = "1.1 -> 3.1"; // What the output should be.
        String actual = list.toString(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the addToFront method of the MyLinkedList class.
     * addToFront adds a given element to the front of the list.
     */
    public static void testAddToFront() {
        System.out.println("Add to front:\n");

        // Description of test.
        System.out.println("Test: add 'a' to the front of the list\n");

        // Linked list of characters.
        MyLinkedList<Character> list = new MyLinkedList<>();

        // Populate the list.
        list.append('b');
        list.append('c');
        list.append('d');

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        // Test adding element to the front of the list.
        list.addToFront('a');

        String expected = "a -> b -> c -> d"; // What the output should be.
        String actual = list.toString(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the insertAt method of the MyLinkedList class.
     * insertAt inserts a given element at a given index in the list.
     */
    public static void testInsertAt() {
        System.out.println("Insert:\n");

        // Description of test.
        System.out.println("Test: insert 'my' at index 1\n");

        // Linked list of strings.
        MyLinkedList<String> list = new MyLinkedList<>();

        // Populate the list.
        list.append("hi");
        list.append("name");
        list.append("is");
        list.append("Mitch");

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        // Test inserting an element at index 1.
        list.insertAt(1, "my");

        String expected = "hi -> my -> name -> is -> Mitch"; // What the output should be.
        String actual = list.toString(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the removeFrom method of the MyLinkedList class.
     * removeFrom removes an element from a given index in the list.
     */
    public static void testRemoveFrom() {
        System.out.println("Remove from index:\n");

        // Description of test.
        System.out.println("Test: remove element from index 3\n");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Populate the list.
        list.append(5);
        list.append(10);
        list.append(15);
        list.append(17);
        list.append(20);

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        // Test removing an element from index 3.
        list.removeFrom(3);

        String expected = "5 -> 10 -> 15 -> 20"; // What the output should be.
        String actual = list.toString(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the get method of the MyLinkedList class.
     * get retrieves an element of the list from a given index.
     */
    public static void testGet() {
        System.out.println("Get:\n");

        // Description of the test.
        System.out.println("Test: Get element at index 2\n");

        MyLinkedList<Double> list = new MyLinkedList<>();

        // Populate the list.
        list.append(0.0);
        list.append(1.2);
        list.append(3.14);
        list.append(14.562);

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        double expected = 3.14; // What the output should be.
        double actual = list.get(2); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the contains method of the MyLinkedList class.
     * contains determines if the given element is in the list or not.
     */
    public static void testContains() {
        System.out.println("Contains:\n");

        MyLinkedList<String> list = new MyLinkedList<>();

        // Populate the list.
        list.append("foo");
        list.append("bar");

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        // Description of the first test.
        System.out.println("Test 1: contains 'bar'?\n");

        boolean expected = true; // What the output should be.
        boolean actual = list.contains("bar"); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);

        // Description of the second test.
        System.out.println("Test 2: contains 'car'?\n");

        expected = false;
        actual = list.contains("car");

        printResults(expected, actual);
    }


    /**
     * Tests the indexOf method of the MyLinkedList class.
     * indexOf returns the index of the given element in the list.
     */
    public static void testIndexOf() {
        System.out.println("Index of:\n");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Populate the list.
        list.append(3);
        list.append(6);
        list.append(9);
        list.append(12);

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        System.out.println("Test 1: index of '9'?\n");

        int expected = 2; // What the output should be.
        int actual = list.indexOf(9); // What the output is.

        printResults(expected, actual);

        System.out.println("Test 2: index of '15'?\n");

        expected = -1;
        actual = list.indexOf(15);

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the reverse method of the MyLinkedList class.
     * reverse reverses the order of the elements in the list.
     */
    public static void testReverse() {
        System.out.println("Reverse:\n");

        // Description of test.
        System.out.println("Test: reverse the order of the elements in the list\n");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Populate the list.
        list.append(100);
        list.append(200);
        list.append(300);
        list.append(400);
        list.append(500);

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        list.reverse();

        String expected = "500 -> 400 -> 300 -> 200 -> 100"; // What the output should be.
        String actual = list.toString(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the clear method of the MyLinkedList class.
     * clear deletes all elements of the list.
     */
    public static void testClear() {
        System.out.println("Clear:\n");

        // Description of test.
        System.out.println("Test: remove all elements from the list\n");

        MyLinkedList<String> list = new MyLinkedList<>();

        // Populate the list.
        list.append("a");
        list.append("b");
        list.append("c");

        // What the list looks like before the test.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        // Clear the list.
        list.clear();

        String expected = "List is empty"; // What the output should be.
        String actual = list.toString(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);
    }


    /**
     * Tests the isEmpty method of the MyLinkedList class.
     * isEmpty determines if the list contains any elements.
     */
    public static void testIsEmpty() {
        System.out.println("IsEmpty:\n");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        System.out.println("Test 1: before adding any elements\n");

        boolean expected = true; // What the output should be.
        boolean actual = list.isEmpty(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);

        // Add an element to make it non-empty
        list.append(42);

        System.out.println("Test 2: After adding an element\n");

        // What the list looks like before test 2.
        System.out.println("Before test:");
        System.out.println(list.toString() + "\n");

        expected = false;
        actual = list.isEmpty();

        printResults(expected, actual);

        // Clear the list again
        list.clear();

        System.out.println("Test 3: After clearing the list\n");

        expected = true;
        actual = list.isEmpty();

        printResults(expected, actual);
    }


    /**
     * Tests the size method of the MyLinkedList class.
     * size returns the number of elements in the list.
     */
    public static void testSize() {
        System.out.println("Size:\n");

        MyLinkedList<Double> list = new MyLinkedList<>();

        // Description of test 1.
        System.out.println("Test 1: before adding any elements\n");

        // Initially empty
        int expected = 0; // What the output should be.
        int actual = list.size(); // What the output is.

        // Displays the output and checks if the list passed the test.
        printResults(expected, actual);

        // Description of test 2.
        System.out.println("Test 2: after adding two elements\n");

        list.append(43.7654);
        list.append(123.3333);

        expected = 2;
        actual = list.size();
        printResults(expected, actual);
    }


    /**
     * Tests the implementation of iterable interface.
     * iterator enables the use of an enhanced for loop over the list.
     */
    public static void testIterator() {
        System.out.println("Iterator:\n");

        // Description of test.
        System.out.println("Test: iterate over and print list using enhanced for loop\n");

        MyLinkedList<Character> list = new MyLinkedList<>();

        // Populate the list.
        list.append('X');
        list.append('Y');
        list.append('Z');

        StringBuilder actual = new StringBuilder(); // What the output is.
        for (char c : list) {
            actual.append(c);
            actual.append(" ");
        }

        String expected = "X Y Z "; // What the output should be.

        // Displays the output and checks if the list passed the test.
        printResults(expected.trim(), actual.toString().trim());
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


    /**
     * Overloaded version of {@link #printResults(String, String)}
     */
    public static void printResults(Double expected, Double actual) {
        System.out.println("After test:");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println(expected.equals(actual) ? "PASS\n" : "FAIL\n");
    }


    /**
     * Overloaded version of {@link #printResults(String, String)}
     */
    public static void printResults(boolean expected, boolean actual) {
        System.out.println("After test:");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println(expected == actual ? "PASS\n" : "FAIL\n");
    }


    /**
     * Overloaded version of {@link #printResults(String, String)}
     */
    public static void printResults(int expected, int actual) {
        System.out.println("After test:");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println(expected == actual ? "PASS\n" : "FAIL\n");
    }
}
