package com.jiridusek.parentheses.validator;

import com.jiridusek.parentheses.view.View;
import java.time.Instant;
import static java.text.MessageFormat.format;

/**
 * Controller class processes user's input from the console
 * and validates it using 4 alternative methods.
 *
 * Class StringValidator uses String class methods.
 * Class RegexValidator uses regular expression.
 * Class DequeValidator uses Deque interface methods.
 * Class StreamValidator uses Stream API.
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
public class Controller {

    private final View view;
    private static final String CMD_QUIT = "quit";

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
     * @param line String User's input
     */
    private void process(String line) {
        // validate using String methods
        validate(new StringValidator(), line);

        // validate using Deque interface
        validate(new DequeValidator(), line);

        // validate using regular expressions
        validate(new RegexValidator(), line);

        // validate using Stream API
        validate(new StreamValidator(), line);
    }

    /**
     * Wrapper method for input validations
     *
     * @param validator Validator Implementation of Validator interface
     * @param line String User's input
     */
    private void validate(Validator validator, String line) {
        // notify user of used method of validation
        if (validator instanceof StringValidator) {
            System.out.println("\nValidating using String methods...");
        } else if (validator instanceof DequeValidator) {
            System.out.println("\nValidating using Deque interface...");
        } else if (validator instanceof RegexValidator) {
            System.out.println("\nValidating using regex...");
        } else if (validator instanceof StreamValidator){
            System.out.println("\nValidating using Stream API...");
        } else {
            System.out.println("\nValidating using unknown method..."); // will not happen but...
        }

        long start = Instant.now().toEpochMilli();
        boolean isValid = validator.validateParentheses(line); // validate input based on validator instance
        long end = Instant.now().toEpochMilli();
        // notify user of validation result and execution time
        System.out.println(format("Expression {0} is {1}.", line, isValid ? "valid" : "invalid"));
        System.out.println(format("Execution time {0} milliseconds.", end - start));
    }
}
