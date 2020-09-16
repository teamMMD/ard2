package com.mwl.ard;

import asciiPanel.AsciiPanel;
import com.mwl.screens.LoadingScreen;
import com.mwl.screens.Screen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class AsciiPrime extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private Screen screen;

    public AsciiPrime(){
        super();
        terminal = new AsciiPanel();
//        System.setOut(terminal);
        add(terminal);
        pack();
        screen = (Screen) new LoadingScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }

    public static void prime(String[] args) {
        AsciiPrime app = new AsciiPrime();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}