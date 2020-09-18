package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;

import java.awt.event.KeyEvent;

public class InitialHelpScreen implements Screen {

    ConsoleManager cm = new ConsoleManager();

    @Override
    public void displayOutput(AsciiPanel terminal) {

        terminal.writeCenter(cm.read_xml().getTitle(), 4);
//        terminal.writeCenter("YOU asked for help, what item do you want to learn about?", 5);
        terminal.writeCenter(cm.read_xml().getDescription(), 6);

        // terminal.writeCenter("[0, Story Details]", 7);
        terminal.writeCenter("Press <0> to see " + cm.read_xml().getChild(0).getTitle(), 8);
        // terminal.writeCenter("[1, Game Controls]", 8);
        terminal.writeCenter("Press <1> to see " + cm.read_xml().getChild(1).getTitle(), 9);

//        terminal.writeCenter("Press <b> to go back", 11);
//        terminal.writeCenter("Press <q> to quit", 12);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 20);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
            case KeyEvent.VK_0:
//                <Story Details>
//                This is a text based game, intro to what this help portion will be about.
//                [0, How do I win]
//                [1, What are rooms]
//                [2, What are items]
//                [3, How do I survive]
//                [b, back]
//                [q, quit]
                return new StoryDetailsHelpScreen();
            case KeyEvent.VK_1:
//                <Game Controls>
//                To play the game, you type commands into the console. There are a plethora of commands to choose from, here are a few options. To call any of these, it is [command] [option]
//                [0, move]
//                [1, pickup]
//                [2, drop]
//                [3, fight]
//                [4, use power]
//                [b, back]
//                [q, quit]
                // TODO: WE DO NOT NEED THE MENU ABOVE BECAUSE ARD2.0 DOESN'T UTILIZE ANY USER INPUT, ONLY ARROW KEYS
                return new GameControlsScreen();
        }
        return this;
    }
}
