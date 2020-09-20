package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.ard.Game;
import org.w3c.dom.ls.LSOutput;

import java.awt.event.KeyEvent;

public class TempScreen implements Screen {

    @Override
    public void displayOutput(AsciiPanel display) {
//        System.out.println("displayOutput run from PlayScreen");
        display.writeCenter("hi...from temp screen", 12);
    }

    @Override
    public void displayOutput(AsciiPanel display, Game game) {

    }

    @Override
    public void customDisplayOutput(AsciiPanel display, String str) {
        display.writeCenter(str, 12);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
