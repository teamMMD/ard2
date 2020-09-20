package com.mwl.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import com.mwl.ard.Game;

public interface Screen {
    public void displayOutput(AsciiPanel terminal);

    public void displayOutput(AsciiPanel terminal, Game game);

    public void customDisplayOutput(AsciiPanel display, String str);

    public Screen respondToUserInput(KeyEvent key);

}
