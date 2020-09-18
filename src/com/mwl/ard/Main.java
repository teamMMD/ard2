package com.mwl.ard;

import asciiPanel.AsciiPanel;

public class Main {

    static AsciiPanel display = new AsciiPanel();

    public static void main(String[] args) {
//        Game game = new Game(); // make a new game and setup features
//        game.newGame(); // start the game

//        AsciiPrime app = new AsciiPrime();    // establish GUI
        Game gameInstance = new Game(display);      // establish/set up new game
        gameInstance.newGame();                 // run game

        // ideally:
        //  new game creates  (is this gameMap??)
        //      - player
        //      - monster
        //      - initial room
        //      - player xy (in initial room)
        //      - monster xy (in initial room)
        //      - "minimap" to track room persistence (aka RoomMap)

        //  game is then passed (along with all the objects specified above) to gameEngine
        //      gameEngine is inside of Game.class
        //      it passes off responsibility to ConsoleManager (why is there not a class that clarifies the logic path? I guess I just have to follow 'gameMap' from one node to the next
        //      or maybe i'm completely wrong and this is all handled through 'play()' like i thought on Monday...



    }
}