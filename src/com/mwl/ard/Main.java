package com.mwl.ard;

public class Main {

    // Replaces app = new AsciiPrime();
    static AsciiPrime app = new AsciiPrime();

    public static void main(String[] args) {
        // Uncomment below to starts ARD1.0
//        Game game = new Game(); // make a new game and setup features
//        game.newGame(); // start the game



        // The code below was replaced with the static variable app
//        app = new AsciiPrime();

        // This starts ARD2.0
        app.prime(args);
    }
}