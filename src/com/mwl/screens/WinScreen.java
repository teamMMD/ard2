package com.mwl.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import com.mwl.ard.Game;

public class WinScreen implements Screen{

    // need input for players name -> then add score to final_scores.txt

    @Override
    public void displayOutput(AsciiPanel terminal) {
        // TODO: need logic to pull in current players name + score
        terminal.writeCenter("CONGRATS YOU WIN!", 5);

        // show scores
        terminal.writeCenter("currentPlayer.getName() + your score is XXX", 10);

        terminal.writeCenter("hit <esc> to exit, <s> to see all high scores, or <enter> to play again =)", 20);
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
        }
        return this;
    }
}

// win condition below
//  if (boss != null && boss.getLife() <= 0) {
//                System.out.println(Codes.Player.withColor(player.getName()) + " killed "
//                        + Codes.Monster.withColor(boss.getName()) + "! You win!!!!");
//          keepScores(player);
//          exit("exit");
//          }