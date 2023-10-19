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
    public static LinkedList add(LinkedList num1, LinkedList num2) {
        // Define a linked list to store the result.
        LinkedList result = new LinkedList();
//
        // Define an int to store the carry.
        int carry = 0;

        // Iterators for the two linked lists.
        Node num1Current = num1.head;
        Node num2Current = num2.head;

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
        return result;
    }

    public static LinkedList multiply(LinkedList num1, LinkedList num2) {
        // Initialize a result linked list to store the product.
        LinkedList result = new LinkedList();
        LinkedList tempResult = new LinkedList();

        // Initialize a variable to keep track of the position of the digits.
        int position = 0;

        // Iterate through each digit in the first linked list.
        Node num1Current = num1.head;

        while (num1Current != null) {
            int carry = 0; // Initialize carry for each position.

            // Append position number of zeros to tempResult.
            for (int i = 0; i < position; i++) {
                tempResult.append(0);
            }

            // Iterate through each digit in the second linked list.
            Node num2Current = num2.head;

            while (num2Current != null) {
                // Calculate the product and add the carry.
                int product = (num1Current.data * num2Current.data) + carry;
                tempResult.append(product % 10); // Append the units digit to tempResult.
                carry = product / 10; // Update the carry for the next iteration.

                num2Current = num2Current.next;
            }

            // If there's any remaining carry, append it.
            if (carry > 0) {
                tempResult.append(carry);
            }

            // Add tempResult to the result.
            result = add(result, tempResult);

            // Increment the position for the next digit in num1.
            position++;
            tempResult = new LinkedList(); // Reset tempResult.

            num1Current = num1Current.next;
        }

        return result;
    }

    //    public static int exponentiate(int base, int power) {
//        if (power < 0) {
//            return exponentiate(1 / base, -power);
//        } else if (power == 0) {
//            return 1;
//        } else if (power % 2 == 0) {
//            int result = exponentiate(base, power / 2);
//            return multiply(result, result);
//        } else {
//            int result = exponentiate(base, (power - 1) / 2);
//            return base * multiply(result, result);
//        }
//    }

    public static LinkedList exponentiate(LinkedList base, int power) {
        LinkedList result = new LinkedList();
        result.append(1); // Initialize result as 1.

        while (power > 0) {
            if (power % 2 == 1) {
                // If power is odd, multiply result by base.
                result = multiply(result, base);
            }
            base = multiply(base, base); // Square the base.
            power /= 2; // Divide the power by 2.
        }

        return result;
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

