package com.mwl.characters;

import com.mwl.environment.Item;
import com.mwl.environment.Room;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.mwl.combat.combatEngine.MonsterFightsPlayer;
import static com.mwl.combat.combatEngine.fightRoomMonster;

public class Wolverine extends Player {
    Monster monster;

    //* CONSTRUCTORS */
    public Wolverine(String name, int life, Room currentRoom, List<Item> itemsInventory, int level) {
        super(name, life, currentRoom, itemsInventory, level);
    }

    //* BUSINESS METHODS */
    /**
     * Method randomly determines who starts an attack: Player or Monster.
     * Method make player and monster fight each other
     */
    @Override
    public void attack() {
        int rand = ThreadLocalRandom.current().nextInt(2);
        switch (rand) {
            case 0:
                fightRoomMonster(this);
                if (getCurrentRoom().getMonsters().size() > 0) {
                    MonsterFightsPlayer(getCurrentRoom().getMonsters().get(0), this);
                }
                break;
            case 1:
                if (getCurrentRoom().getMonsters().size() > 0) {
                    MonsterFightsPlayer(getCurrentRoom().getMonsters().get(0), this);
                }
                fightRoomMonster(this);
                break;
        }
    }

    /**
     * Method boosts player's life by 50 points if the player has a special item - "power_stone" in inventory
     */
    @Override //health boost
    public void useSpecialPower() {
        if (this.getItemsInventory().contains(Item.valueOf("Power_stone"))) {
            int lifeValue = getLife();
            lifeValue += 50;
            setLife(lifeValue);
            this.getItemsInventory().remove(Item.valueOf("Power_stone"));
            System.out.println(this.getName() + " has power stone in inventory and just used special power to self boost health by 50!");
        } else {
            System.out.println("Can't use special power without power stone in inventory!");
        }
    }

}
