package com.snap.userInput;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);

    private String userInput;

    private boolean running = true;

    public String handleInput() {

        while(running) {
            userInput = scanner.nextLine().toLowerCase();

            if(!userInput.isEmpty()) {
                System.out.println("Press enter to continue");
            } else {
                running = !running;
            }

        }

        return userInput;
    }
}
