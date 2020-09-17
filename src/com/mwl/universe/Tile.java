package com.mwl.universe;

import asciiPanel.AsciiPanel;

import java.awt.Color;

public enum Tile {
    WALL((char)255, AsciiPanel.green),
    GROUND((char)250, AsciiPanel.brightBlack);

    private Color color;
    char character;

    Tile(char c, Color color) {
        this.character = c;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public char getCharacter() {
        return character;
    }
}
