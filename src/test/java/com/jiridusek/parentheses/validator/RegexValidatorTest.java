package com.jiridusek.parentheses.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexValidatorTest {

    private final Validator validator = new RegexValidator();

    private static final String EMPTY = "";
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String CLOSED_PARENTHESIS = "()";
    private static final String REDUNDANT_LEFT = "((1*5)+(5-2)";
    private static final String REDUNDANT_RIGHT = "(1*5)+(5-2))";
    private static final String REDUNDANT_LEFT_WITH_LEAD = "2+((1*5)+(5-2)";
    private static final String REDUNDANT_LEFT_WITH_TRAIL = "((1*5)+(5-2)+2";
    private static final String REDUNDANT_RIGHT_WITH_LEAD = "1+(1*5)+(5-2))";
    private static final String REDUNDANT_RIGHT_WITH_TRAIL = "(1*5)+(5-2))+2";
    private static final String NO_PARENTHESIS = "abc";
    private static final String CLOSED_WITH_TRAIL = "()abc";
    private static final String CLOSED_WITH_LEAD = "abc()";

    @Test
    void validateParentheses() {
        // assert statements
        assertTrue(validator.validateParentheses(EMPTY));
        assertFalse(validator.validateParentheses(LEFT_PARENTHESIS));
        assertFalse(validator.validateParentheses(RIGHT_PARENTHESIS));
        assertTrue(validator.validateParentheses(CLOSED_PARENTHESIS));
        assertFalse(validator.validateParentheses(REDUNDANT_LEFT));
        assertFalse(validator.validateParentheses(REDUNDANT_RIGHT));
        assertFalse(validator.validateParentheses(REDUNDANT_LEFT_WITH_LEAD));
        assertFalse(validator.validateParentheses(REDUNDANT_LEFT_WITH_TRAIL));
        assertFalse(validator.validateParentheses(REDUNDANT_RIGHT_WITH_LEAD));
        assertFalse(validator.validateParentheses(REDUNDANT_RIGHT_WITH_TRAIL));
        assertTrue(validator.validateParentheses(NO_PARENTHESIS));
        assertTrue(validator.validateParentheses(CLOSED_WITH_TRAIL));
        assertTrue(validator.validateParentheses(CLOSED_WITH_LEAD));
    }
}