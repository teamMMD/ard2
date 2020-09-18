package com.mwl.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public interface Screen {
    public void displayOutput(AsciiPanel terminal);

    public void customDisplayOutput(AsciiPanel display, String str);

    public Screen respondToUserInput(KeyEvent key);

}
