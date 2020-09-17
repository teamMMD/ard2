package com.mwl.universe;

import com.mwl.environment.Room;

import java.util.Random;

public class FloorPlan {
    public String[][] floorPlan = new String[80][22];
    public Room randRoom;
    int xBound = 80;
    int yBound = 22;

    int randX = 36;
    int randY = 9;

    public FloorPlan(String roomDescription, int roomID) {
        this.randRoom = new Room(roomDescription, roomID);
        this.floorPlan = makeFloorPlan(randRoom);
    }

    public String[][] makeFloorPlan(Room room) {
        System.out.println("\n  randRoom: " + randRoom.toString());

        int roomStartX = (int) Math.floor((xBound - randRoom.getWidth()) / 2) - 1;
        int roomStopX = roomStartX + randRoom.getWidth();

        int roomStartY = (int) Math.floor((yBound - randRoom.getHeight()) / 2) - 2;
        int roomStopY = roomStartY + randRoom.getHeight();

        System.out.println("Y => " + roomStartY + "-" + roomStopY);
        System.out.println("X => " + roomStartX + "-" + roomStopX);

        int topDoorX = randomInRange(roomStartX, roomStopX);

        for (int x = 0; x < xBound; x++) {
            for (int y = 0; y < yBound; y++) {
                if (x == randX && y == randY) {
                    if (randRoom.getMonsters().size() > 0) {
                        floorPlan[x][y] = "M";
                    } else {
                        System.out.println("no monster to render");
                        floorPlan[x][y] = " ";
                    }
                } else if (x == 39 && y == 11) {
                    floorPlan[x][y] = "@";
                } else if (y == roomStartY && x == topDoorX) {
                    floorPlan[x][y] = "+";
                } else if (x > roomStartX && x < roomStopX && y > roomStartY && y < roomStopY) {
                    floorPlan[x][y] = " ";
                } else {
                    floorPlan[x][y] = ".";
                }
            }
        }
        return floorPlan;
    }

    public int randomUpTo(int num) {
        return (int) new Random().nextInt(num);
    }
    public int randomInRange(int min, int max) {
//        max += 1;
        int result = (int) (Math.random() * (max - min + 1) + min);
        if (result == max) result -= 1;
        System.out.println("randomNumInRange " + min + "-" + max + ": " + result);
        return result;
    }

}
