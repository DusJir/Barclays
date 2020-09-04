package com.jiridusek.parentheses.view;

import java.util.Scanner;

/**
 * ConsoleUI class reads the user's input from the console
 *
 * @author  Jiri Dusek
 * @version 1.0
 * @since   2020-09-04
 */
public class ConsoleUI implements View {

    private final Scanner console = new Scanner(System.in);

    /**
     * This method is used for reading user's input
     * @return String Returns user's input from the console
    */
    public String read() {
        return console.nextLine();
    }
}

