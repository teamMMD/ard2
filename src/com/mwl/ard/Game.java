package com.mwl.ard;

import com.mwl.characters.Monster;
import com.mwl.characters.MonsterFactory;
import com.mwl.characters.Player;
import com.mwl.environment.Direction;
import com.mwl.environment.Item;
import com.mwl.environment.Room;
import com.mwl.environment.RoomMap;
import com.mwl.util.Codes;
import com.mwl.util.ConsoleManager;
import com.mwl.util.TextParser;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

import static com.mwl.util.ExitGame.exit;

public class Game {
    private Player player;                // player reference
    private RoomMap gameMap;              // map of the rooms
    private Random random = new Random(); // generate new room
    private Monster boss;                 // boss monster reference
    private ApplicationMain app;

    // default constructor
    public Game() {
        gameMap = new RoomMap();
    }

    public Game(ApplicationMain app) {
        gameMap = new RoomMap();
        app = app;
        System.out.println("so we have the app in here now...");
    }

    /**
     * Method to run the basic logic behind the game. Parse player's input, execute command,
     * return boolean if game is still going.
     *
     * @return
     */
    private boolean play() {
        // let player know we expect an input
        System.out.print("> ");

        // ask what player wants to do
        // Text parser
        String[] command = TextParser.parser();

        // do that thing
        switch (command[0]) {
            case "move" -> {
                int size = gameMap.size();
                gameMap.moveCharacter(player, Direction.valueOf(command[1]));
                increaseScore(size);
            }
            case "look" -> Look(player, command[1]);
            case "flight" -> Flight(player, command[1]);
            case "fight" -> Fight(player, command[1]);
            case "pickup" -> player.pickUpItem(Item.valueOf(command[1]));
            case "drop" -> player.dropItem(Item.valueOf(command[1]));
            case "help" -> ConsoleManager.gameExplanation();
            case "unlock" -> unlockChest(player);
            case "use" -> UsePower(player, command[1]);
            case "show" -> Show(player, command[1]);
        }

        return true;
    }

    /**
     * Method to start a new game. Prints out a welcome message and game banner.
     */
    public void newGame() {
        // print game intro and let the player pick a character Iron Man or Wolverine
        ConsoleManager.gameIntro();
        player = ConsoleManager.choosePlayer(gameMap);

        boolean playGame = true;
        while (playGame) {
            // keep playing game until it passes back as false
            playGame = play();

            if (boss == null) {
                boss = MonsterFactory.createBossMonster(player);
                player.getCurrentRoom().addMonster(boss);
            }
            if (boss != null && boss.getLife() <= 0) {
                System.out.println(Codes.Player.withColor(player.getName()) + " killed "
                        + Codes.Monster.withColor(boss.getName()) + "! You win!!!!");
                keepScores(player);
                exit("exit");
            }
        }
        // quit message
        System.out.println("Thanks for playing! Come play again");
    }

    /*
    Stubbed out method to prepare for flight action
     */
    private void Flight(Player player, String option) {
        System.out.println("Flying " + option);
        // run method to do the action
    }

    /**
     * Method to instigate player fighting. Calls player's attack method
     */
    private void Fight(Player player, String option) {
        System.out.println("fighting " + option);
        player.attack();
    }

    /**
     * Method to instigate player using their special power.
     */
    private void UsePower(Player player, String option) {
        System.out.println("use " + option);
        player.useSpecialPower();
    }

    /**
     * Method to look at different objects. "Around" to give details about the room.
     */
    private void Look(Player player, String option) {
        switch (option) {
            case "Around" -> player.getCurrentRoom().overview();
            default -> itemRequestDesc(option);
        }
    }

    /**
     * Method to show player's status.
     */
    private void Show(Player player, String option) {
        switch (option) {
            case "Status" -> player.printStats();
            default -> itemRequestDesc(option);
        }
    }

    /**
     * Method to invoke unlock chest method
     */
    private void unlockChest(Player player) {
        player.getCurrentRoom().unlockChest();
    }

    /**
     * Method to call increment score for the player when the gamemap has increased in size.
     */
    private void increaseScore(int previousSize) {
        int newSize = gameMap.size();
        if (newSize > previousSize) {
            player.incrementScore();
        }
    }

    /**
     * Method to print an item description.
     */
    public void itemRequestDesc(String item){
        if(player.playerAndRoomItems().contains(Item.valueOf(item))){
            for (Item itemx : player.playerAndRoomItems()) {
                if (itemx.name().equals(item)){
                    System.out.println(itemx.getDescription());
                    break;
                }
            }
        }else {
            System.out.println("Item not present");
        }
    }

    /**
     * Method to keep Player's score, name and a time stamp in resources/scores/final_scores.txt.
     */
    public static void keepScores(Player player) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("resources/scores/final_scores.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please enter your name here to record your " + Codes.Score.withColor("score") + " for this game: ");
        String name = ConsoleManager.scanner().nextLine();

        LocalDateTime time = LocalDateTime.now();
        writer.append("<Final score for this game @" + time + ">" + "\n");
        writer.append("[" + name + "] (" + player.getName() + "): " + player.getScore() + " points \n");
        writer.println();

        writer.close();
    }
}

