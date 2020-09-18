package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.ard.AsciiPrime;
import com.mwl.util.ConsoleManager;
import com.mwl.util.MenuTrieNode;

import java.awt.event.KeyEvent;

public class StoryDetailsHelpScreen implements Screen {

    // TODO: I DONT THINK I WANT TO INSTANTIATE A NEW CONSOLE MANAGER IN EACH HELP SCREEN.
    // WHAT DO I DO?
    ConsoleManager cm = new ConsoleManager();

    MenuTrieNode storyDetails = cm.read_xml().getChild(0);

    // method chaining get.child() -> is this okay?
        // rXML(#) -> cm.read_xml().getChild(0).getChild(#).getTitle()
    // instantiaton of consolemanager in each screen -> is this okay?
    // do i need to combine screens because it looks as if we are repeating code?

    @Override
    public void displayOutput(AsciiPanel terminal) {

        terminal.writeCenter(storyDetails.getTitle(), 5);
        terminal.writeCenter(storyDetails.getDescription(), 7);
        terminal.writeCenter("Press <0> to see " + storyDetails.getChild(0).getTitle(), 9);
        terminal.writeCenter("Press <1> to see more information", 10);

        terminal.writeCenter("hit [b] to return to the previous screen", 18);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 20);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_0:
               return new HowToWinHelpScreen();
            case KeyEvent.VK_1:
                return new RoomsItemsSurviveHelpScreen();
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
            case KeyEvent.VK_B:
                return new InitialHelpScreen();
        }
        return new LoadingScreen();
    }

}
