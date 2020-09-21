package com.mwl.ard;

import asciiPanel.AsciiPanel;
import com.mwl.environment.RoomMap;
import com.mwl.screens.PlayScreen;
import com.mwl.screens.Screen;
import com.mwl.screens.ScreenPrinter;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L; // helps JVM find the same AsciiPanel object repeatedly

    private static Game game;
    private static Screen screen;
    private static AsciiPanel gui;
    private static ScreenPrinter screenPrinter = new ScreenPrinter();

    public ApplicationMain() {
        super();
        gui = new AsciiPanel();
        add(gui);
        pack();
        screen = (Screen) new PlayScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint() {
        gui.clear();
        screen.displayOutput(gui);
        super.repaint();
    }

    public void showThis(String str) {
        gui.clear();
        screen.customDisplayOutput(gui, str);
        super.repaint();
    }

    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        screen.displayOutput(gui, new RoomMap());
        System.out.println("before");
        screenPrinter.printScreen(gui, screen, new String[80][22]);
        System.out.println("after");
        app.setVisible(true);
//        game = new Game(); // make a new game and setup features
//        game.newGame(); // start the game
//        screen.displayOutput(gui, new RoomMap());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // KeyListener implementation
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // KeyListener implementation
        screen = screen.respondToUserInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // KeyListener implementation
    }
}