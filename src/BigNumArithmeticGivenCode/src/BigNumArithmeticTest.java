package BigNumArithmeticGivenCode.src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigNumArithmeticTest {

    @Test
    public void testIntToLinkedList() {
        LinkedList result = BigNumArithmetic.intToLinkedList(12345);
        String strResult = BigNumArithmetic.linkedListToString(result);
        assertEquals("12345", strResult);
    }

    @Test
    public void testLinkedListToInt() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(9);
        linkedList.append(8);
        linkedList.append(7);
        int result = BigNumArithmetic.LinkedListToInt(linkedList);
        assertEquals(789, result);
    }

    @Test
    public void testLinkedListToString() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        String result = BigNumArithmetic.linkedListToString(linkedList);
        assertEquals("4321", result);
    }

    @Test
    public void testAdd() {
        LinkedList num1 = BigNumArithmetic.intToLinkedList(12345);
        LinkedList num2 = BigNumArithmetic.intToLinkedList(54321);
        LinkedList result = BigNumArithmetic.add(num1, num2);
        String strResult = BigNumArithmetic.linkedListToString(result);
        assertEquals("66666", strResult);
    }

    @Test
    public void testMultiply() {
        LinkedList num1 = BigNumArithmetic.intToLinkedList(12345);
        LinkedList num2 = BigNumArithmetic.intToLinkedList(54321);
        LinkedList result = BigNumArithmetic.multiply(num1, num2);
        String strResult = BigNumArithmetic.linkedListToString(result);
        assertEquals("670592745", strResult);
    }

    @Test
    public void testExponentiate() {
        LinkedList base = BigNumArithmetic.intToLinkedList(2);
        LinkedList result = BigNumArithmetic.exponentiate(base, 10);
        String strResult = BigNumArithmetic.linkedListToString(result);
        assertEquals("1024", strResult);
    }
}

