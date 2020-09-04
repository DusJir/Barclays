package com.jiridusek.parentheses.validator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This class provides validation based on Deque interface
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
class DequeValidator implements Validator {
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
    @Override
    public boolean validateParentheses(String line) {
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
}
