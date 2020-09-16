package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;

import java.awt.event.KeyEvent;

public class LoadingScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        ConsoleManager cm = new ConsoleManager();
        String title = cm.gameTitle();
//        terminal.write(title, 1, 1);
        terminal.writeCenter("-- press [enter] to start --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
//        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
        switch(key.getKeyCode()) {
//            case KeyEvent.VK_RIGHT:
//                return new RightArrowScreen();
//            case KeyEvent.VK_KP_RIGHT:
//                return new RightArrowScreen();
//            case KeyEvent.VK_LEFT:
//                return new LeftArrowScreen();
//            case KeyEvent.VK_UP:
//                return new UpArrowScreen();
//            case KeyEvent.VK_DOWN:
//                return new DownArrowScreen();
            case KeyEvent.VK_ENTER:
                return new PlayScreen();
        }
        return this;
    }
}
