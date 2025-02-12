package org.allyssinxd.zerodrpg.entities;

import org.allyssinxd.zerodrpg.systems.Inventory;
import org.allyssinxd.zerodrpg.systems.Skill;

public class Player extends Entity{

    private Inventory inventory;
    private Skill[] skills;

    public Player(int life, int level, int stamina) {
        super("Elias",life, level, stamina);
    }

}
