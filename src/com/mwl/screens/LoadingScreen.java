package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoadingScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        ConsoleManager cm = new ConsoleManager();
        System.out.println(cm.l1 + cm.l2 + cm.l3);

        terminal.writeCenter(cm.l1, 1, Color.black, Color.green);
        terminal.writeCenter(cm.l2, 2);
        terminal.writeCenter(cm.l3, 3);

        // TODO: remove this later
        terminal.writeCenter("~matthew~ press <W> to see win screen", 11);
        terminal.writeCenter("~matthew~ press <L> to see lose screen", 12);


        terminal.writeCenter("-- press [enter] to start yet 'Another Random Destiny' --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        System.out.println(key.getKeyCode());
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new PlayScreen();
            case KeyEvent.VK_H:
                return new InitialHelpScreen();
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            case KeyEvent.VK_W:
                return new WinScreen();
            case KeyEvent.VK_L:
                return new LoseScreen();
        }
        return this;
//        return key.getKeyCode() == KeyEvent.VK_ENTER ? new TempScreen() : this;

    }
}
