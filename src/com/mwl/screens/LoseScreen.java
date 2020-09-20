package com.mwl.screens;

import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {

    // need input for players name -> then add score to final_scores.txt
    // winscreen and losescreen are very similar in code. how to NOT REPEAT CODE

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Sorry, you lose. :( ", 5, Color.white);
        terminal.writeCenter("Whould you like to try again? :) ", 7, Color.orange);

        // show scores
        terminal.writeCenter("currentPlayer.getName() + your score is XXX", 11, Color.white);

        terminal.writeCenter("hit <esc> to exit, <s> to see all high scores, or <enter> to play again =)", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            case KeyEvent.VK_ENTER:
                System.out.println("play again");
                return new LoadingScreen();
            case KeyEvent.VK_S:
                System.out.println("show all players scores");
                return new ScoreScreen();
        }
        return this;
    }
}
