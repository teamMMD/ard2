package com.mwl.characters;

public class Normal extends Monster {
    Player player;

    //* CONSTRUCTORS */
    public Normal(String name, int life, String description) {
        setName(name);
        setDescription(description);
        setLife(life);
        //   setCurrentRoom(currentRoom);
    }

    //* BUSINESS METHODS */
    // Abstract methods with local logic
    @Override
    public void attack() {
    }

    @Override
    public void move() {
        // Add move code
    }

}
