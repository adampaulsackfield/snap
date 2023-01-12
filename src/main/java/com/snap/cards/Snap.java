package com.snap.cards;

import com.snap.userInput.UserInput;

public class Snap extends CardGame{
    public Snap(String name) {
        super(name);
    }

    public void test() {
        UserInput scanner = new UserInput();

        System.out.println(scanner.handleInput());
    }

}
