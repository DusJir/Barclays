package com.jiridusek.parentheses;

import com.jiridusek.parentheses.validator.Controller;
import com.jiridusek.parentheses.view.ConsoleUI;

/**
 * This exercise is an implementation of task given by Barclays HR.
 * It simply validates input from console for parentheses being
 * correctly placed within an input.
 *
 * TASK description:
 * Imagine you have formulas like this: (a+(b-a))
 * You are supposed to implement method ValidateParentheses(), which will verify that the parentheses match up correctly
 * i.e. each parenthesis is closed with the correct closing counterpart and there is no extra parenthesis anywhere.
 * If parentheses match, it should return true, otherwise false.
 * Implement tests that will validate that code is working properly.
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
public class Parentheses {

    /**
     * An entry point for Parentheses program
     *
     * @param args Unsupported
     */
    public static void main(String[] args) {
        ConsoleUI view = new ConsoleUI();
        Controller controller = new Controller(view);
        controller.run();
    }
}
