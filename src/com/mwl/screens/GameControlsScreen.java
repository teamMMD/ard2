package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.environment.Direction;
import com.mwl.util.ConsoleManager;
import com.mwl.util.MenuTrieNode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameControlsScreen implements Screen {

    ConsoleManager cm = new ConsoleManager();
    MenuTrieNode gameControls = cm.read_xml().getChild(1);

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter(gameControls.getTitle(), 4, Color.orange);
        terminal.writeCenter("ARD2.0 only utilizes movement from arrow keys.", 6, Color.white);
        terminal.writeCenter("to go " + Direction.North + " press the <up> arrow key.", 9, Color.white);
        terminal.writeCenter("to go " + Direction.South + " press the <down> arrow key.", 10, Color.white);
        terminal.writeCenter("to go " + Direction.East + " press the <right> arrow key.", 11, Color.white);
        terminal.writeCenter("to go " + Direction.West + " press the <left> arrow key.", 12, Color.white);
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
