package org.allyssinxd.zerodrpg.entity;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Entity {

    private final int id;
    private String name;
    private int life;
    private int level;
    private int stamina;

    public Entity(String name, int life, int level, int stamina){
        this.id = hashCode();
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public int getLife() {
        return life;
    }

    public int getStamina() {
        return stamina;
    }

    public String getName() {
        return name;
    }
}
