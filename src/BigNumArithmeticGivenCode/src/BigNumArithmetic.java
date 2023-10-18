package BigNumArithmeticGivenCode.src;

import javax.swing.*;

public class BigNumArithmetic {

    /**
     * The entry point of the program.
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Expected exactly 1 argument: a file name.");
        }
        String filePath = args[0];
        FileProcessor.processFile(filePath);
    }

    public static LinkedList intToLinkedList(int num) {
        LinkedList result = new LinkedList();

        // Ensure non-negative number
        if (num < 0) {
            num = Math.abs(num);
        }

        while (num > 0) {
            int digit = num % 10;
            result.append(digit);
            num /= 10;
        }

        return result;
    }

    public static int LinkedListToInt(LinkedList linkedList){
        // Convert the result linked list to an integer.
        int finalResult = 0;
        int multiplier = 1; // Used to calculate the place value of each digit.
        Node current = linkedList.head;
        while (current != null) {
            finalResult += current.data * multiplier;
            multiplier *= 10;
            current = current.next;
        }

        return finalResult;
    }
    public static int add(int num1, int num2) {
        // Define a linked list to store the result.
        LinkedList result = new LinkedList();

        // Define an int to store the carry.
        int carry = 0;

        // Convert both integers in the array into linked lists using intToLinkedList method.
        LinkedList num1List = intToLinkedList(num1);
        LinkedList num2List = intToLinkedList(num2);

        // Iterators for the two linked lists.
        Node num1Current = num1List.head;
        Node num2Current = num2List.head;

        while (num1Current != null || num2Current != null || carry > 0) {
            int num1Digit = (num1Current != null) ? num1Current.data : 0;
            int num2Digit = (num2Current != null) ? num2Current.data : 0;
            int sum = num1Digit + num2Digit + carry;

            if (sum < 10) {
                result.append(sum);
                carry = 0;
            } else {
                result.append(sum % 10);
                carry = sum / 10;
            }

            if (num1Current != null) {
                num1Current = num1Current.next;
            }
            if (num2Current != null) {
                num2Current = num2Current.next;
            }
        }
        return LinkedListToInt(result);
    }
    public static int multiply(int num1,int num2) {
        // Initialize an integer to store the result.
        int result = 0;
        //Define multiplier for long division
        int multiplier = 1;
        LinkedList tempResult =  new LinkedList();

        // Convert both integers in the array into linked lists using intToLinkedList method.
        LinkedList num1List = intToLinkedList(num1);
        LinkedList num2List = intToLinkedList(num2);

        // Iterator for the first linked list.
        Node num1Current = num1List.head;

        while (num1Current != null) {
            // Initialize an integer to store the carry.
            int carry = 0;

            // Iterator for the second linked list.
            Node num2Current = num2List.head;

            // Iterate through each element in the second linked list.
            while (num2Current != null) {

                // Multiply the current digits and add the carry.
                int product = (num1Current.data * num2Current.data) + carry;

                tempResult.append(product);
                // Update the carry for the next iteration.
                carry = product / 10;

                num2Current = num2Current.next;
            }
            tempResult.append(carry);
            // Add the carry (if any) to the result.
            result  += LinkedListToInt(tempResult) * multiplier;
            multiplier *= 10;
            tempResult = new LinkedList();

            num1Current = num1Current.next;
        }

        return result;
    }

    public static int exponentiate(int base, int power){

    }



    public String processLinkedListArithmetic(String expression) {
        String[] expressions = expression.split("\\s+");

        if (expressions.length != 3) {
            System.err.println("Invalid expression: " + expression);
//            return;
        }

        String operand1 = expressions[0];
        String operator = expressions[1];
        String operand2 = expressions[2];

        int num1 = Integer.parseInt(operand1);
        int num2 = Integer.parseInt(operand2);

        int result = 0;

        switch (operator) {
            case "+":
                for (int i = 0; i < operand1.length(); i++) {
//                    int numOne = operand1[i];
//                    int numTwo = operand2[i];

//                    result = numOne + numTwo;

                }
                break;
            case "*":
                result = num1 * num2;
                break;
            case "^":
                result = (int) Math.pow(num1, num2);
                break;
            default:
                System.err.println("Invalid operator: " + operator);
                return "Invalid operator: " + operator;
        }

        return operand1 + " " + operator + " " + operand2 + " = " + result;

    }
}

