package org.allyssinxd.zerodrpg;

import org.allyssinxd.zerodrpg.entities.Player;
import org.allyssinxd.zerodrpg.systems.*;
import org.allyssinxd.zerodrpg.utils.TextUtils;

import java.io.File;
import java.util.ArrayList;

public class Game {

    private GameState gameState;
    private final Player player;
    private ArrayList<String> flags = new ArrayList<String>();
    private String activeTrigger = "";
    private int chapter;
    private final int savingSlot;
    private boolean isOver = false;
    private Location location;

    public NarrativeManager narrativeManager = new NarrativeManager(this);
    public ExplorationManager explorationManager = new ExplorationManager(this);
    public BattleManager battleManager = new BattleManager(this);
    public TriggerManager triggerManager = new TriggerManager(this);

    public Game(int savingSlot){
        location = Location.getLocationById("CorvellanFlorest");
        gameState = GameState.NARRATIVE;
        player = new Player(50, 1, 20);
        this.savingSlot = savingSlot;
        chapter = 0;
    }


    public static Game NewGame()
    {
        TextUtils.typeText("Criando novo jogo...", 100);

        //Search empty slot
        boolean cleanSlot = false;
        int i = 0;
        File gameSaveFile = new File("");
        while (!cleanSlot) {
            gameSaveFile = new File(System.getProperty("user.dir") +
                    "/saves/slot"+i+".json");
            if(!gameSaveFile.exists()) cleanSlot=true;
            i++;
        }

        //Creates new game on the found empty slot
        try{
            if(gameSaveFile.createNewFile()) {
                System.out.println("Novo jogo criado no Slot " + i);
            }
            else return null;

            return new Game(i);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public static Game LoadGame(int slot){
        TextUtils.typeText("Carregando jogo...", 100);
        //CHANGE THIS LATER
        return new Game(slot);
    }

    public ArrayList<String> getFlags() {
        return flags;
    }

    public void setFlags(ArrayList<String> flags) {
        this.flags = flags;
    }

    public void AddFlag(String flag){
        flags.add(flag);
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getSavingSlot() {
        return savingSlot;
    }

    public Player getPlayer() {
        return player;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public String getActiveTrigger() {
        return activeTrigger;
    }

    public void setActiveTrigger(String activeTrigger) {
        this.activeTrigger = activeTrigger;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
