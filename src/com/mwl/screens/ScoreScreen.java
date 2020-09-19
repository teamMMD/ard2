package com.mwl.screens;

import asciiPanel.AsciiPanel;

import javax.sound.sampled.Line;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScoreScreen implements Screen {
    BufferedReader reader;

    public String scoreScreenReadFromTxt(int x) {
        try {
            if (Files.readAllLines(Paths.get("resources/scores/final_scores.txt")).size() >= x
            && Files.readAllLines(Paths.get("resources/scores/final_scores.txt")).get(x).length() > 0) {
                String line = Files.readAllLines(Paths.get("resources/scores/final_scores.txt")).get(x);
                return line;
            }

        } catch (IOException e) {
            //e.printStackTrace();
            return "no scores";
        }
        return "no scores";
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter(this.scoreScreenReadFromTxt(3), 5);
        terminal.writeCenter(this.scoreScreenReadFromTxt(5), 6);
        terminal.writeCenter(this.scoreScreenReadFromTxt(7), 7);
        terminal.writeCenter(this.scoreScreenReadFromTxt(9), 8);
        terminal.writeCenter(this.scoreScreenReadFromTxt(11), 9);
        terminal.writeCenter(this.scoreScreenReadFromTxt(13), 10);

    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}
