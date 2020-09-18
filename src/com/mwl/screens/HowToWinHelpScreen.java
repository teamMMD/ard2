package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;
import com.mwl.util.MenuTrieNode;

import java.awt.event.KeyEvent;

public class HowToWinHelpScreen implements Screen {

    ConsoleManager cm = new ConsoleManager();
    MenuTrieNode howDoIwin = cm.read_xml().getChild(0).getChild(0);
    MenuTrieNode howToFindBoss = cm.read_xml().getChild(0).getChild(0).getChild(0);
    MenuTrieNode howToKillBoss = cm.read_xml().getChild(0).getChild(0).getChild(1);

    @Override
    public void displayOutput(AsciiPanel terminal) {


        terminal.writeCenter(howDoIwin.getTitle(), 5);
        terminal.writeCenter(howDoIwin.getDescription(), 6);

        terminal.writeCenter(howToFindBoss.getTitle(), 8);
        terminal.writeCenter(howToFindBoss.getDescription(), 9);

        terminal.writeCenter(howToKillBoss.getTitle(), 11);
        terminal.writeCenter(howToKillBoss.getDescription(), 12);

        terminal.writeCenter("hit [b] to return to the previous screen", 18);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 20);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
            case KeyEvent.VK_B:
                return new InitialHelpScreen();
        }
        return new LoadingScreen();
    }
}
