package com.jiridusek.parentheses.validator;

/**
 * This class provides validation based on Stream API
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
class StreamValidator implements Validator {
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
    @Override
    public boolean validateParentheses(String line) {
        // check if input is null or empty
        if (line == null || line.isEmpty()) {
            return true;
        }

        // I found this solution here:
        // https://codereview.stackexchange.com/questions/106219/checking-balanced-parenthesis-string
        // IMO it does what it is supposed to do in two lines of code (which is nice) but it is hard to read
        return line.chars().mapToDouble(i -> i == '(' ? 1 : i == ')' ? -1 : 0).reduce(0,
                (a, b) -> a == 0 && b == -1 ? Double.NaN : a + b) == 0;
    }
}
