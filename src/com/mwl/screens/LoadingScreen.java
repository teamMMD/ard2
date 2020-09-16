package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadingScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        ConsoleManager cm = new ConsoleManager();
        System.out.println(cm.l1 + cm.l2 + cm.l3);

        terminal.writeCenter(cm.l1, 1, Color.black, Color.green);
        terminal.writeCenter(cm.l2, 2);
        terminal.writeCenter(cm.l3, 3);
        terminal.writeCenter("-- press [enter] to start yet 'Another Random Destiny' --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        System.out.println(key.getKeyCode());
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new PlayScreen();
            case KeyEvent.VK_H:
                return new HelpScreen();
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
        }
        return this;
//        return key.getKeyCode() == KeyEvent.VK_ENTER ? new TempScreen() : this;

    }
}
