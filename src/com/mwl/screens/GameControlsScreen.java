package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.environment.Direction;
import com.mwl.util.ConsoleManager;
import com.mwl.util.MenuTrieNode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameControlsScreen implements Screen {

//    ConsoleManager cm = new ConsoleManager();
    MenuTrieNode gameControls = ConsoleManager.read_xml_gameControls().getChild(0);


    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter(gameControls.getParent().getTitle(), 4, Color.orange);
        terminal.writeCenter(gameControls.getParent().getDescription(), 6, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(0).getDescription(), 9, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(1).getDescription(), 10, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(2).getDescription(), 11, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(3).getDescription(), 12, Color.white);
        // wasd***
//        terminal.writeCenter("to go " + Direction.North + " press the <up> arrow key.", 9, Color.white);
//        terminal.writeCenter("to go " + Direction.South + " press the <down> arrow key.", 10, Color.white);
//        terminal.writeCenter("to go " + Direction.East + " press the <right> arrow key.", 11, Color.white);
//        terminal.writeCenter("to go " + Direction.West + " press the <left> arrow key.", 12, Color.white);
        terminal.writeCenter("hit [b] to return to the previous screen", 21, Color.gray);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
            case KeyEvent.VK_B:
                return new InitialHelpScreen();
        }
        return new LoadingScreen();
    }

}
