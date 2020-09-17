package com.mwl.util;

public class ExitGame {

    //* BUSINESS METHODS */
    /**
     * Method that terminates the game
     */
    public static void exit(String exit) {
        if (exit.strip().toLowerCase().equals("exit")) {
            System.exit(0);
        }
    }
}


