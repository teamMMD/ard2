package com.mwl.screens;

import asciiPanel.AsciiPanel;
import com.mwl.util.ConsoleManager;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadingScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        String title = ConsoleManager.gameIntro();
        System.out.println(title);
        String[] splitTitle = title.split("");
        String[] splitTitle2 = Arrays.copyOf(splitTitle, splitTitle.length + 1);
        splitTitle2[0] = "";

        String line1 = "";
        for (Integer i = 1; i < 80; i++) {
            if (i < 79)
                System.out.println(splitTitle[i]);
                line1 = line1 + splitTitle[i];
        }
        String line2 = "";
        for (Integer i = 81; i < 160; i++) {
            if (i < 79)
                System.out.println(splitTitle[i]);
                line2 = line2 + splitTitle[i];
        }
        String line3 = "";
        for (Integer i = 161; i < 240; i++) {
            if (i < 79)
                System.out.println(splitTitle[i]);
            line3 = line3 + splitTitle[i];
        }
        String line4 = "";
        for (Integer i = 241; i < 320; i++) {
            if (i < 79)
                System.out.println(splitTitle[i]);
            line4 = line4 + splitTitle[i];
        }
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);

//        terminal.write(topLine, 1, 1);
        terminal.writeCenter("-- press [enter] to start --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new TempScreen() : this;
    }
}
