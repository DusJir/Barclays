package com.jiridusek.parentheses.controller;

import com.jiridusek.parentheses.view.View;
import java.time.Instant;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.text.MessageFormat.format;

/**
 * Controller class processes user's input from the console
 * and validates it using 4 alternative methods.
 *
 * Method 'validateParentheses' uses String class methods.
 * Method 'validateParenthesesRegex' uses regular expression.
 * Method 'validateParenthesesDeque' uses Deque interface methods.
 * Method 'validateParenthesesStream' uses Stream API.
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
public class Controller {

    private final View view;
    private final static String CMD_QUIT = "quit";

    public Controller(View view) {
        this.view = view;
    }

    /**
     * Method run reads user's input from the console via View interface's implementation.
     * User has to press key 'ENTER' to process the input.
     * When user types in keyword 'quit', it closes the program.
    */
    public void run() {
        String line;

        // read input console
        while ((line = view.read()) != null) {
            // check for command keys
            // quit command, exit the program
            if (CMD_QUIT.equals(line)) {
                return;
            } else {
                process(line.trim());
            }
        }
    }

    /**
     * This method processes user's input.
     * It calls 4 alternative methods to validate the input.
     *
     * @param line String An user's input
     */
    void process(String line) {
        long start;
        long end;
        boolean isValid;

        // validate using String methods
        System.out.println("\nValidating using String methods...");
        start = Instant.now().toEpochMilli();
        isValid = validateParentheses(line);
        end = Instant.now().toEpochMilli();
        System.out.println(format("Expression {0} is {1}.", line, isValid ? "valid" : "invalid"));
        System.out.println(format("Execution time {0} milliseconds", end - start));

        // validate using regex
        System.out.println("\nValidating using regex...");
        start = Instant.now().toEpochMilli();
        isValid = validateParenthesesRegex(line);
        end = Instant.now().toEpochMilli();
        System.out.println(format("Expression {0} is {1}.", line, isValid ? "valid" : "invalid"));
        System.out.println(format("Execution time {0} milliseconds", end - start));

        // validate using Deque
        System.out.println("\nValidating using Deque...");
        start = Instant.now().toEpochMilli();
        isValid = validateParenthesesDeque(line);
        end = Instant.now().toEpochMilli();
        System.out.println(format("Expression {0} is {1}.", line, isValid ? "valid" : "invalid"));
        System.out.println(format("Execution time {0} milliseconds", end - start));

        // validate using stream
        System.out.println("\nValidating using Stream API...");
        start = Instant.now().toEpochMilli();
        isValid = validateParenthesesStream(line);
        end = Instant.now().toEpochMilli();
        System.out.println(format("Expression {0} is {1}.", line, isValid ? "valid" : "invalid"));
        System.out.println(format("Execution time {0} milliseconds", end - start));
        System.out.println("------------------------------------------");
    }

    /**
     * This method validates user's input for parentheses being correctly closed (if any is there)
     * using String class methods.
     *
     * If the input is an empty string it returns true.
     * It is design-driven decision. Validator should take care about parentheses and parentheses only.
     *
     * @param line String
     * @return boolean Returns true if input is valid
     */
    boolean validateParentheses(String line) {
        // check if input is null or empty
        if (line == null || line.isEmpty()) {
            return true;
        }

        // validate parentheses using String methods
        int leading = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                leading++;
            } else if (line.charAt(i) == ')') {
                if (leading == 0) {   // all parentheses are closed already
                    return false;
                }
                leading--;
            }
        }
        // return true if leading counter is 0
        return leading == 0;
    }

    /**
     * This method validates user's input for parentheses being correctly closed (if any is there)
     * using regular expressions.
     *
     * If the input is an empty string it returns true.
     * It is design-driven decision. Validator should take care about parentheses and parentheses only.
     *
     * @param line String
     * @return boolean Returns true if input is valid
     */
    boolean validateParenthesesRegex(String line) {
        // check if input is null or empty
        if (line == null || line.isEmpty()) {
            return true;
        }

        // validate parentheses using regex
        Pattern p = Pattern.compile("\\([^()]*\\)");
        Matcher m;

        // find and replace all parentheses with an empty char
        while ((m = p.matcher(line)).find()) {
            line = m.replaceAll("");
        }

        // return true if no parentheses left
        return !(line.contains("(") || line.contains(")"));
    }

    /**
     * This method validates user's input for parentheses being correctly closed (if any is present)
     * using Deque interface methods.
     *
     * If the input is an empty string it returns true.
     * It is design-driven decision. Validator should take care about parentheses and parentheses only.
     *
     * @param line String
     * @return boolean Returns true if input is valid
     */
    boolean validateParenthesesDeque(String line) {
        // check if input is null or empty
        if (line == null || line.isEmpty()) {
            return true;
        }

        Deque<Character> storage = new LinkedList<>();

        // validate parentheses using Deque
        for (int i = 0; i < line.length(); i++) {
            char x = line.charAt(i);

            // if actual character is a leading parenthesis then push it to the storage
            if (x == '(') {
                storage.push(x);
                continue;
            }

            // closing character found, remove leading one from the storage if not empty
            if (x == ')') {
                if (!storage.isEmpty()) {
                    storage.pop();
                } else {
                    return false; // closing parenthesis with no leading one
                }
            }
        }
        // storage has to be empty if expression is valid
        return (storage.isEmpty());
    }

    /**
     * This method validates user's input for parentheses being correctly closed (if any is present)
     * using Stream API methods.
     *
     * If the input is an empty string it returns true.
     * It is design-driven decision. Validator should take care about parentheses and parentheses only.
     *
     * @param line String
     * @return boolean Returns true if input is valid
     */
    boolean validateParenthesesStream(String line) {
        // check if input is null or empty
        if (line == null || line.isEmpty()) {
            return true;
        }

        // I found this solution here:
        // https://codereview.stackexchange.com/questions/106219/checking-balanced-parenthesis-string
        // IMO it is pretty smart but hard to read
        return line.chars().mapToDouble(i -> i == '(' ? 1 : i == ')' ? -1 : 0).reduce(0,
            (a, b) -> a == 0 && b == -1 ? Double.NaN : a + b) == 0;
    }

}
