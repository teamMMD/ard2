package com.mwl.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private int screenWidth;
    private int screenHeight;
    private String[][] world = new String[80][22];

    @Override
    public void displayOutput(AsciiPanel terminal) {
        for (Integer x = 0; x < 79; x++) {
            for (int y = 0; y < 21; y++) {
                world[x][y] = ".";
                terminal.write(".", x, y);
            }
        }

    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            case KeyEvent.VK_LEFT:
                return new TempScreen();
        }
        return this;
    }
}
