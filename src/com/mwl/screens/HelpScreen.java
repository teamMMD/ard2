package com.mwl.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class HelpScreen implements Screen {


    // need key input -> render next help screen.

    // maybe capture static MenuTrieNode read_xml() return

    // read characters, terminal output.

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("<HELP MENU>", 5);
        terminal.writeCenter("You asked for help, what item do you want to learn about?", 6);
        terminal.writeCenter("[0, Story Details]", 7);
        terminal.writeCenter("[1, Game Controls]", 8);
        terminal.writeCenter("[b, back]", 9);
        terminal.writeCenter("[q, quit]", 10);

        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 20);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
        }
        return this;
    }
}
