package BigNumArithmeticGivenCode.src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigNumArithmeticTest {

    @Test
    public void testIntToLinkedList() {
        LinkedList linkedList = BigNumArithmetic.intToLinkedList(12345);
        // Assert that the linked list contains the expected values
        assertEquals(5, linkedList.head.data);
        assertEquals(4, linkedList.head.next.data);
        assertEquals(3, linkedList.head.next.next.data);
        // Add more assertions as needed
    }

    @Test
    public void testLinkedListToInt() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(3);
        int num = BigNumArithmetic.LinkedListToInt(linkedList);
        // Assert that the integer is as expected
        assertEquals(345, num);
    }

    @Test
    public void testAdd() {
        int result = BigNumArithmetic.add(1234, 5678);
        // Assert that the addition result is as expected
        assertEquals(6912, result);
    }

    @Test
    public void testMultiply() {
        int result = BigNumArithmetic.multiply(12, 34);
        // Assert that the multiplication result is as expected
        assertEquals(408, result);
    }
}
