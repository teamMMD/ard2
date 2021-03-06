package com.mwl.characters;

import com.mwl.util.Codes;

public abstract class Monster {
    private String name;
    private String description;
    private int life;
    //  private Room currentRoom;

    //* CONSTRUCTORS */
    /**
     * Default constructor
     */
     public Monster() {}

    //* BUSINESS METHODS */
    public abstract void attack();

    public abstract void move();

    //* GETTERS AND SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return Codes.Monster.withColor(getName()) + " -- \'" + getDescription() + "\' -- " + Codes.Life.withColor("life: " + getLife());
    }
}
