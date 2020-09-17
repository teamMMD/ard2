package com.mwl.util.commands;

public class Unlock implements Commands {
    /**
     * Unlock Class implements the Commands interface and throws exception if user input is not valid
     */
    @Override
    public void do_command(String option) throws IllegalArgumentException {
        if (option == null || !option.equals("Chest")) {
            throw new IllegalArgumentException("Unlock what?");
        }
    }
}
