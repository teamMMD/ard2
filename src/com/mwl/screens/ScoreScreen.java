package com.mwl.screens;

import asciiPanel.AsciiPanel;

import javax.sound.sampled.Line;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ScoreScreen implements Screen {

    public String scoreScreenReadFromTxt(int x) {
        try {
            if (Files.readAllLines(Paths.get("resources/scores/final_scores.txt")).size() >= x
            && Files.readAllLines(Paths.get("resources/scores/final_scores.txt")).get(x).length() > 0) {
                String line = Files.readAllLines(Paths.get("resources/scores/final_scores.txt")).get(x);
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        int x = 1;
        int y = 4;
        List<String> linesList = new ArrayList<>();
        // create hashMap
            // store scores as key ->
            // values as associated string.

//        List<Integer> scoresList = new ArrayList<>();

        // for every line in the supplied txt file
        for (int i = 1; i < this.scoreScreenReadFromTxt(x).length(); i++) {

            // compare each lines score
            String line = this.scoreScreenReadFromTxt(x);
            linesList.add(line);
            System.out.println(linesList);

            // sort() linesList by scores in each element
//            Collections.sort(Integer.valueOf(linesList.get(i).substring(linesList.get(i).indexOf(":") + 1, linesList.get(i).indexOf("points")).trim()));
            Collections.sort(linesList);
            System.out.println(linesList);

//            for (int idx = 0; idx < linesList.size(); idx++ ) {
//                Integer score = Integer.valueOf(linesList.get(idx).substring(linesList.get(idx).indexOf(":") + 1, linesList.get(idx).indexOf("points")).trim());
//
//                scoresList.add(score);
//                System.out.println(scoresList);
//                // for all the lines in linesList,
//                // compare by score
//            }

            terminal.writeCenter(this.scoreScreenReadFromTxt(x), y);
            x = x + 2;
            y++;


        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}
