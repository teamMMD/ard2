package com.mwl.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class TempScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        System.out.println("did it work?");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}
