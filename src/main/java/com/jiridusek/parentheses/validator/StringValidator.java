package com.jiridusek.parentheses.validator;

/**
 * This class provides validation based on String methods
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
class StringValidator implements Validator {
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
    @Override
    public boolean validateParentheses(String line) {
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
}
