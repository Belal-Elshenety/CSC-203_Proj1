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
        LinkedList result = BigNumArithmetic.add(BigNumArithmetic.intToLinkedList(1111111111), BigNumArithmetic.intToLinkedList(222222222));
        assertEquals(3, result.head.data);
        assertEquals(3, result.head.next.data);
        assertEquals(3, result.head.next.next.data);
    }

    @Test
    public void testMultiply() {
        LinkedList result = BigNumArithmetic.multiply(BigNumArithmetic.intToLinkedList(12),BigNumArithmetic.intToLinkedList( 34));
        // Assert that the multiplication result is as expected
        assertEquals(8, result.head.data);
        assertEquals(0, result.head.next.data);
        assertEquals(4, result.head.next.next.data);
    }

    @Test
    public void testExponentiate() {
        LinkedList result = BigNumArithmetic.exponentiate(BigNumArithmetic.intToLinkedList(2), 9);
        // Assert that the result of 2^10 is as expected
        assertEquals(2, result.head.data);
        assertEquals(1, result.head.next.data);
        assertEquals(5, result.head.next.next.data);
    }
}
