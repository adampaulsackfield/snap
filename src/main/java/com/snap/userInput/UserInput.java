package com.snap.userInput;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);
    private String userInput;
    private boolean running;

    public String handleInput() {
        running = true;

        while (running) {
            userInput = scanner.nextLine().toLowerCase();

            if (!userInput.equals("snap") && !userInput.isEmpty()) {
                System.out.println("Type 'snap' when you see a pair");
            } else {
                running = false;
            }

        }

        return userInput;
    }

    public String getName() {
        return scanner.nextLine().toLowerCase();
    }
}