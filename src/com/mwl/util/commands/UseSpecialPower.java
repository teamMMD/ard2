package com.mwl.util.commands;

public class UseSpecialPower implements Commands {
    /**
     * UseSpecialPower Class implements the Commands interface and throws exception if user input is not valid
     */
    @Override
    public void do_command(String option) throws IllegalArgumentException {
        if (!option.equals("Power")) {
            throw new IllegalArgumentException("Use what?");
        }
    }
}
