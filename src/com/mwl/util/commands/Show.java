package com.mwl.util.commands;

import com.mwl.environment.Item;

import java.util.Arrays;
import java.util.List;

/**
 * Show Class implements the Commands interface and validate user input
 */
public class Show implements Commands {

        @Override
        public void do_command(String option) throws IllegalArgumentException {
            List<String> valid = List.of("Status");
            if (option == null || !valid.contains(option)
                    && !Arrays.stream(Item.values()).anyMatch((items) -> items.name().equals(option)))
                throw new IllegalArgumentException("Show what?");
        }
    }
