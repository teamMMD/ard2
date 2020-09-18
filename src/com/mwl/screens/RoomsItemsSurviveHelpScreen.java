package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;

import java.awt.event.KeyEvent;

public class RoomsItemsSurviveHelpScreen implements Screen{

    ConsoleManager cm = new ConsoleManager();

    @Override
    public void displayOutput(AsciiPanel terminal) {

        terminal.writeCenter(cm.read_xml().getChild(0).getChild(1).getTitle(), 5);
        terminal.writeCenter(cm.read_xml().getChild(0).getChild(1).getDescription(), 6);

        terminal.writeCenter(cm.read_xml().getChild(0).getChild(2).getTitle(), 8);
        terminal.writeCenter(cm.read_xml().getChild(0).getChild(2).getDescription(), 9);

        terminal.writeCenter(cm.read_xml().getChild(0).getChild(3).getTitle(), 11);
        terminal.writeCenter(cm.read_xml().getChild(0).getChild(3).getDescription(), 12);

        terminal.writeCenter("hit [b] to return to the previous screen", 18);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 20);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
            case KeyEvent.VK_B:
                return new StoryDetailsHelpScreen();
        }
        return new LoadingScreen();
    }
}
