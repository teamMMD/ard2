package com.mwl.util.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// TODO: danny to implement score command
public class Score implements Commands{

    @Override
    public void do_command(String option) throws IllegalArgumentException {
       // System.out.println("i need scores to display here.");
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("resources/scores/final_scores.txt"));
            String scores = reader.readLine();
            while (scores != null) {
                System.out.println(scores);
                scores = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e){
            System.out.println("file not found");
            e.printStackTrace();
        }
    }
}
