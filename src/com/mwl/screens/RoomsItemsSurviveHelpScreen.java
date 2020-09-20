package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;
import com.mwl.util.MenuTrieNode;

import java.awt.event.KeyEvent;

public class RoomsItemsSurviveHelpScreen implements Screen{

    ConsoleManager cm = new ConsoleManager();
    MenuTrieNode whatAreRooms = cm.read_xml().getChild(0).getChild(1);
    MenuTrieNode whatAreItems = cm.read_xml().getChild(0).getChild(2);
    MenuTrieNode howDoISurvive = cm.read_xml().getChild(0).getChild(3);

    @Override
    public void displayOutput(AsciiPanel terminal) {

        terminal.writeCenter(whatAreRooms.getTitle(), 4);
        terminal.writeCenter(whatAreRooms.getDescription().substring(0,66), 5);
        terminal.writeCenter(whatAreRooms.getDescription().substring(67,128), 6);

        terminal.writeCenter(whatAreItems.getTitle(), 8);
        terminal.writeCenter(whatAreItems.getDescription().substring(0,79), 9);
        terminal.writeCenter(whatAreItems.getDescription().substring(80,135), 10);
        terminal.writeCenter(whatAreItems.getDescription().substring(135,199), 11);

        terminal.writeCenter(howDoISurvive.getTitle(), 13);
        terminal.writeCenter(howDoISurvive.getDescription().substring(0,55), 14);

        terminal.writeCenter("hit [b] to return to the previous screen", 19);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 21);
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
