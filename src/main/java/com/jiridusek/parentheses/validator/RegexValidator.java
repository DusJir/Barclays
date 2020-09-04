package com.jiridusek.parentheses.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides validation based on regular expressions
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
 class RegexValidator implements Validator {

    // compile regex patter only once
    private static final Pattern p = Pattern.compile("\\([^()]*\\)");

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
    @Override
    public boolean validateParentheses(String line) {
        // check if input is null or empty
        if (line == null || line.isEmpty()) {
            return true;
        }

        // validate parentheses using regex
        Matcher m;
        // find and replace all parentheses with an empty char
        while ((m = p.matcher(line)).find()) {
            line = m.replaceAll("");
        }

        // return true if no parentheses left
        return !(line.contains("(") || line.contains(")"));
    }
}
