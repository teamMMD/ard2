package com.mwl.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class ScreenPrinter {
    public Screen screen;
    public AsciiPanel asciiPanel;
    int width = 79;
    int height = 21;
    public String[][] floorPlan = new String[width][height];
    int pX = 39;
    int pY = 11;
    String playerMeeple = "@";
    String floor = " ";

    public Screen printScreen(AsciiPanel asciiPanel, Screen screen, String[][] floorPlan) {
        System.out.println("hello");
        this.screen = screen;
        this.floorPlan = floorPlan;
//        asciiPanel.writeCenter("test", 4);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == pX && y == pY) {
                    floorPlan[x][y] = playerMeeple;
                } else {
                    floorPlan[x][y] = floor;
                }
                asciiPanel.write(floorPlan[x][y], x, y);
            }
        }
        System.out.println("screen painted");
        return screen;
    }

    public void updateFloorPlan(int x, int y) {
        floorPlan[pX][pY] = floor;
        pX = pX + x;
        pY = pY + y;
        floorPlan[pX][pY] = playerMeeple;
        System.out.println("floorplan updated");
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_W:
                updateFloorPlan(0, -1);
                return printScreen(asciiPanel, screen, floorPlan);
            case KeyEvent.VK_ENTER:
                return new TempScreen();
        }
        return printScreen(asciiPanel, screen, floorPlan);
    }

}
