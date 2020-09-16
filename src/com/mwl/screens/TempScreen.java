package com.mwl.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class TempScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 12);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_BACK_SPACE ? new LoadingScreen() : this;
    }
}
