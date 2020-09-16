package com.mwl.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class HelpScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("help text goes here...", 11);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 12);
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
