package BigNumArithmeticGivenCode.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                char operator = ' ';
                for (char ch : new char[]{'+', '*', '^'}) {
                    if (line.indexOf(ch) != -1) {
                        operator = ch;
                        break;
                    }
                }

                String[] operands = line.split("\\" + operator);
                String operand1 = operands[0].trim().replaceFirst("^0+", "");
                String operand2 = operands[1].trim().replaceFirst("^0+", "");

                LinkedList result;
                switch (operator) {
                    case '+':
                        result = BigNumArithmetic.add(
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operand1)),
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operand2)));
                        break;
                    case '*':
                        result = BigNumArithmetic.multiply(
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operand1)),
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operand2)));
                        break;
                    case '^':
                        result = BigNumArithmetic.exponentiate(
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operand1)),
                                Integer.parseInt(operand2));
                        break;
                    default:
                        System.out.println("Invalid operation in line: " + line);
                        continue;
                }

                // Convert result to string and print
                String resultInt = BigNumArithmetic.linkedListToString(result);
                String output = operand1 + " " + operator + " " + operand2 + " = " + resultInt;
                if (scan.hasNext()){
                    System.out.println(output);
                } else {
                    System.out.print(output);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
