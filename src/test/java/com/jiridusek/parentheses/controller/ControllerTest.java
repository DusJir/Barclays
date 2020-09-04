package com.jiridusek.parentheses.controller;

import com.jiridusek.parentheses.view.ConsoleUI;
import com.jiridusek.parentheses.view.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private final View view = new ConsoleUI();
    private final Controller controller = new Controller(view);

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
        assertTrue(controller.validateParentheses(EMPTY));
        assertFalse(controller.validateParentheses(LEFT_PARENTHESIS));
        assertFalse(controller.validateParentheses(RIGHT_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_PARENTHESIS));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_TRAIL));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_TRAIL));
        assertTrue(controller.validateParentheses(NO_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_WITH_TRAIL));
        assertTrue(controller.validateParentheses(CLOSED_WITH_LEAD));
    }

    @Test
    void validateParenthesesRegex() {
        // assert statements
        assertTrue(controller.validateParentheses(EMPTY));
        assertFalse(controller.validateParentheses(LEFT_PARENTHESIS));
        assertFalse(controller.validateParentheses(RIGHT_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_PARENTHESIS));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_TRAIL));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_TRAIL));
        assertTrue(controller.validateParentheses(NO_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_WITH_TRAIL));
        assertTrue(controller.validateParentheses(CLOSED_WITH_LEAD));
    }

    @Test
    void validateParenthesesDeque() {
        // assert statements
        assertTrue(controller.validateParentheses(EMPTY));
        assertFalse(controller.validateParentheses(LEFT_PARENTHESIS));
        assertFalse(controller.validateParentheses(RIGHT_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_PARENTHESIS));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_TRAIL));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_TRAIL));
        assertTrue(controller.validateParentheses(NO_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_WITH_TRAIL));
        assertTrue(controller.validateParentheses(CLOSED_WITH_LEAD));
    }

    @Test
    void validateParenthesesStream() {
        // assert statements
        assertTrue(controller.validateParentheses(EMPTY));
        assertFalse(controller.validateParentheses(LEFT_PARENTHESIS));
        assertFalse(controller.validateParentheses(RIGHT_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_PARENTHESIS));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_LEFT_WITH_TRAIL));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_LEAD));
        assertFalse(controller.validateParentheses(REDUNDANT_RIGHT_WITH_TRAIL));
        assertTrue(controller.validateParentheses(NO_PARENTHESIS));
        assertTrue(controller.validateParentheses(CLOSED_WITH_TRAIL));
        assertTrue(controller.validateParentheses(CLOSED_WITH_LEAD));
    }
}