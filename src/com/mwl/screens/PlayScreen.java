package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.ard.Game;
import com.mwl.characters.Player;
import com.mwl.environment.Room;
import com.mwl.environment.RoomMap;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private Room room;
    private Player player;
    private int screenWidth;
    private int screenHeight;
    private RoomMap minimap;
    private AsciiPanel display;

    @Override
    public void displayOutput(AsciiPanel display) {
//        System.out.println("displayOutput run from PlayScreen");
//        display.writeCenter("hi...", 9);
    }

    @Override
    public void displayOutput(AsciiPanel display, Game game) {
        System.out.println("game: " + game);
        display.writeCenter("game should be sout'd", 10);
    }

    @Override
    public void displayOutput(AsciiPanel display, RoomMap minimap) {
        this.minimap = minimap;
        System.out.println("minimap: " + minimap);
        display.writeCenter("minimap should be sout'd now", 11);
    }

    @Override
    public void customDisplayOutput(AsciiPanel display, String str) {
        display.writeCenter(str, 12);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
//        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen().displayOutput(display, minimap) : this;
    }
}
