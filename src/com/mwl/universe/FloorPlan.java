package com.mwl.universe;

import com.mwl.environment.Room;

import java.util.Random;

public class FloorPlan {
    public String[][] floorPlan = new String[80][22];
    public Room randRoom;

    int randX = (int) new Random().nextInt(40) + 20;
    int randY = (int) new Random().nextInt(10) + 6;

    public FloorPlan(String roomDescription, int roomID) {
        this.randRoom = new Room(roomDescription, roomID);
        this.floorPlan = makeFloorPlan(randRoom);
    }

    public String[][] makeFloorPlan(Room room) {
        System.out.println("\n  randRoom: " + randRoom.toString());

        for (Integer x = 0; x < 79; x++) {
            for (int y = 0; y < 21; y++) {
                if (x == randX && y == randY) {
                    if (randRoom.getMonsters().size() > 0) {
                        floorPlan[x][y] = "M";
                    } else {
                        System.out.println("no monster to render");
                        floorPlan[x][y] = " ";
                    }
                } else if (x == 40 && y == 12) {
                    floorPlan[x][y] = "@";
                } else if (x > 20 && x < 60 && y > 5 && y < 15) {
                    floorPlan[x][y] = " ";
                } else {
                    floorPlan[x][y] = ".";
                }
            }
        }
        return floorPlan;
    }

}
