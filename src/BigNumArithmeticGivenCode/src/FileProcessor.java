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

                LinkedList result;
                switch (operator) {
                    case '+':
                        result = BigNumArithmetic.add(
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operands[0].trim())),
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operands[1].trim())));
                        break;
                    case '*':
                        result = BigNumArithmetic.multiply(
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operands[0].trim())),
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operands[1].trim())));
                        break;
                    case '^':
                        result = BigNumArithmetic.exponentiate(
                                BigNumArithmetic.intToLinkedList(Integer.parseInt(operands[0].trim())),
                                Integer.parseInt(operands[1].trim()));
                        break;
                    default:
                        System.out.println("Invalid operation in line: " + line);
                        continue;
                }

                // Convert result to string and print
                String resultInt = BigNumArithmetic.linkedListToString(result);
                System.out.println(operands[0].trim() + " " + operator + " " + operands[1].trim() + " = " + resultInt);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
