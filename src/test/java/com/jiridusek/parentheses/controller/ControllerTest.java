package com.jiridusek.parentheses.controller;

import com.jiridusek.parentheses.view.ConsoleUI;
import com.jiridusek.parentheses.view.View;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private final View view = new ConsoleUI();
    private final Controller controller = new Controller(view);

    @Test
    void validateParentheses() {
        // assert statements
        assertTrue(controller.validateParentheses(""), "Empty string is valid");
        assertFalse(controller.validateParentheses("("), "Expression '(' is invalid");
        assertFalse(controller.validateParentheses(")"), "Expression ')' is invalid");
        assertTrue(controller.validateParentheses("()"), "Expression '()' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))"), "Expression '(1*5)+(9-(1*1))' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))+1"), "Expression '(1*5)+(9-(1*1))+1' is valid");
        assertFalse(controller.validateParentheses("(1*5)+(9-(1*1))*(1+1))"), "Expression '(1*5)+(9-(1*1))*(1+1))' is invalid");
        assertTrue(controller.validateParentheses("abc"), "Expression 'abc' is valid");
        assertTrue(controller.validateParentheses("()abc"), "Expression '()abc' is valid");
        assertTrue(controller.validateParentheses("abc()"), "Expression 'abc()' is valid");
    }

    @Test
    void validateParenthesesRegex() {
        assertTrue(controller.validateParentheses(""), "Empty string is valid");
        assertFalse(controller.validateParentheses("("), "Expression '(' is invalid");
        assertFalse(controller.validateParentheses(")"), "Expression ')' is invalid");
        assertTrue(controller.validateParentheses("()"), "Expression '()' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))"), "Expression '(1*5)+(9-(1*1))' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))+1"), "Expression '(1*5)+(9-(1*1))+1' is valid");
        assertFalse(controller.validateParentheses("(1*5)+(9-(1*1))*(1+1))"), "Expression '(1*5)+(9-(1*1))*(1+1))' is invalid");
        assertTrue(controller.validateParentheses("abc"), "Expression 'abc' is valid");
        assertTrue(controller.validateParentheses("()abc"), "Expression '()abc' is valid");
        assertTrue(controller.validateParentheses("abc()"), "Expression 'abc()' is valid");
    }

    @Test
    void validateParenthesesDeque() {
        assertTrue(controller.validateParentheses(""), "Empty string is valid");
        assertFalse(controller.validateParentheses("("), "Expression '(' is invalid");
        assertFalse(controller.validateParentheses(")"), "Expression ')' is invalid");
        assertTrue(controller.validateParentheses("()"), "Expression '()' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))"), "Expression '(1*5)+(9-(1*1))' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))+1"), "Expression '(1*5)+(9-(1*1))+1' is valid");
        assertFalse(controller.validateParentheses("(1*5)+(9-(1*1))*(1+1))"), "Expression '(1*5)+(9-(1*1))*(1+1))' is invalid");
        assertTrue(controller.validateParentheses("abc"), "Expression 'abc' is valid");
        assertTrue(controller.validateParentheses("()abc"), "Expression '()abc' is valid");
        assertTrue(controller.validateParentheses("abc()"), "Expression 'abc()' is valid");
    }

    @Test
    void validateParenthesesStream() {
        assertTrue(controller.validateParentheses(""), "Empty string is valid");
        assertFalse(controller.validateParentheses("("), "Expression '(' is invalid");
        assertFalse(controller.validateParentheses(")"), "Expression ')' is invalid");
        assertTrue(controller.validateParentheses("()"), "Expression '()' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))"), "Expression '(1*5)+(9-(1*1))' is valid");
        assertTrue(controller.validateParentheses("(1*5)+(9-(1*1))+1"), "Expression '(1*5)+(9-(1*1))+1' is valid");
        assertFalse(controller.validateParentheses("(1*5)+(9-(1*1))*(1+1))"), "Expression '(1*5)+(9-(1*1))*(1+1))' is invalid");
        assertTrue(controller.validateParentheses("abc"), "Expression 'abc' is valid");
        assertTrue(controller.validateParentheses("()abc"), "Expression '()abc' is valid");
        assertTrue(controller.validateParentheses("abc()"), "Expression 'abc()' is valid");
    }
}