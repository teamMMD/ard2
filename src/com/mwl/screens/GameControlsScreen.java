package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.environment.Direction;
import com.mwl.util.ConsoleManager;
import com.mwl.util.MenuTrieNode;

import java.awt.event.KeyEvent;

public class GameControlsScreen implements Screen {

    ConsoleManager cm = new ConsoleManager();
    MenuTrieNode gameControls = cm.read_xml().getChild(1);

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter(gameControls.getTitle(), 5);
        terminal.writeCenter("ARD2.0 only utilizes movement from arrow keys.", 7);
        terminal.writeCenter("to go " + Direction.North + " press the <up> arrow key.", 9);
        terminal.writeCenter("to go " + Direction.South + " press the <down> arrow key.", 10);
        terminal.writeCenter("to go " + Direction.East + " press the <right> arrow key.", 11);
        terminal.writeCenter("to go " + Direction.West + " press the <left> arrow key.", 12);
        terminal.writeCenter("hit [b] to return to the previous screen", 18);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 20);
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
