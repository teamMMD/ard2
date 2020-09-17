package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.environment.Room;
import com.mwl.universe.FloorPlan;

import java.awt.event.KeyEvent;
import java.util.Random;

public class PlayScreen implements Screen {
    private int screenWidth;
    private int screenHeight;
    public FloorPlan thisFloor;

    @Override
    public void displayOutput(AsciiPanel terminal) {
//        terminal.writeCenter("--- PlayScreen?? --- ", 12);
        thisFloor = new FloorPlan("test", 1);
        System.out.println(thisFloor);
        for (int x = 0; x < 79; x++) {
            for (int y = 0; y < 21; y++) {
                terminal.write(thisFloor.floorPlan[x][y], x, y);
            }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            case KeyEvent.VK_LEFT:
                return new TempScreen();
            case KeyEvent.VK_ENTER:
                return new PlayScreen();
//            case KeyEvent.VK_W:
//                player.move(0, -1);
        }
        return this;
    }
}
