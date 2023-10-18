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
                String line = scan.nextLine();

                // Process each line of the input file here.
                // Initialize a StringBuilder to build the resulting string.
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);

                    // Skip spaces and leading zeroes
                    if (Character.isWhitespace(currentChar) || (currentChar == '0')) {
                        continue;
                    }

                    // Check if it's a number
                    if (Character.isDigit(currentChar)) {
                        // Append digits to the result until you reach a non-digit character
                        while (i < line.length() && Character.isDigit(line.charAt(i))) {
                            result.append(line.charAt(i));
                            i++;
                        }
                        // Move back by 1 to handle the non-digit character in the next iteration
                        i--;
                    } else if (currentChar == '+' || currentChar == '*' || currentChar == '^') {
                        // If it's an operator (+, *, ^), append it to the result
                        result.append(currentChar);
                    } else {
                        // If it's any other character, break
                        break;
                    }
                }

                // Print or use the 'result' string as needed.
                System.out.println(result.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

}
