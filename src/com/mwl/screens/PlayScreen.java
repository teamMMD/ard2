package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.environment.Room;
import com.mwl.universe.FloorPlan;

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PlayScreen implements Screen {
    private int screenWidth;
    private int screenHeight;
    public FloorPlan thisFloor = new FloorPlan("sigh", 1);
    public int pX = 39;
    public int pY = 11;

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("--- PlayScreen?? --- ", 12);
        thisFloor = new FloorPlan("test", 1);
        System.out.println(thisFloor);
        for (int x = 0; x < 79; x++) {
            for (int y = 0; y < 21; y++) {
                if (x == pX && y == pY) terminal.write("@", x, y);
                terminal.write(thisFloor.floorPlan[x][y], x, y);
            }
        }
    }

//    public void drawMove(int pX, int pY) {
//        thisFloor.renderFloor(pX, pY);
//    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
//            case KeyEvent.VK_ESCAPE:
//                System.exit(1);
//            case KeyEvent.VK_LEFT:
//                return new TempScreen();
//            case KeyEvent.VK_ENTER:
//                return new PlayScreen();
            case KeyEvent.VK_W:
                System.out.println("'w' pressed!");
                thisFloor.updateFloorPlan(0, -1);
                System.out.println("does it work?");
//                wait(3000);
                break;
        }
        return this;
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
