package com.mwl.screens;

import asciiPanel.AsciiPanel;

import javax.sound.sampled.Line;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreScreen implements Screen {
    BufferedReader reader;

    public String scoreScreenReadFromTxt() {

        //the following code skips lines <...>
//        try {
//            reader = new BufferedReader(new FileReader("resources/scores/final_scores.txt"));
//            String scores = reader.readLine();
//            while (scores != null) {
//                System.out.println(scores);
//                scores = reader.readLine();
//                return scores;
//            }
//            reader.close();
//        } catch ( IOException e) {
//            System.out.println("file not found");
//            e.printStackTrace();
//        }
//        return "no one played yet";

        //String thisLine = null;

        try {
            // open input stream test.txt for reading purpose.
            BufferedReader br = new BufferedReader(new FileReader("resources/scores/final_scores.txt"));

//            while ((thisLine = br.readLine()) != null) {
//                return thisLine;
//            }
                String line;
                while ((line = br.readLine()) != null) {
                    // process the line.
                    return line;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "no scores";
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter(this.scoreScreenReadFromTxt(), 5);
        //TODO: we want to be able print the text to multiple lines.
        // the above code limits the output to only one line #5

    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}
