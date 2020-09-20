package com.mwl.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import com.mwl.ard.Game;
import com.mwl.environment.RoomMap;

public interface Screen {
    public void displayOutput(AsciiPanel display);

    public void displayOutput(AsciiPanel display, Game game);

    public void displayOutput(AsciiPanel display, RoomMap minimap);

    public void customDisplayOutput(AsciiPanel display, String str);

    public Screen respondToUserInput(KeyEvent key);

}
