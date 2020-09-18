package com.mwl.screens;

import asciiPanel.AsciiPanel;
import org.w3c.dom.ls.LSOutput;

import java.awt.event.KeyEvent;

public class PlayScreen2 implements Screen {

    @Override
    public void displayOutput(AsciiPanel display) {
//        System.out.println("displayOutput run from PlayScreen");
        display.writeCenter("hi...again", 12);
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
