package org.allyssinxd.zerodrpg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.allyssinxd.zerodrpg.entities.Player;
import org.allyssinxd.zerodrpg.utils.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    //Mechs
    private final Player player;

    //History
    private GameState gameState;
    private ArrayList<String> flags = new ArrayList<String>();
    private int chapter;

    private final int savingSlot;

    public Game(int savingSlot){
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
            gameSaveFile = new File(System.getProperty("user.dir") + "/saves/slot"+i+".json");
            if(!gameSaveFile.exists()) cleanSlot=true;
            i++;
        }

        //Creates new game on the found empty slot
        try{
            if(gameSaveFile.createNewFile())
                System.out.println("Novo jogo criado no Slot " + i);
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

    public void update(){
        switch (gameState){
            case NARRATIVE :
                handleNarrative();
            case EXPLORATION:
                return;
        }
    }

    private void handleNarrative() {
        if(getChapter() == 0){
            if(!getFlags().contains("inicio_jogo")){
                handleChapter(0);
                return;
            }
            if(getFlags().contains("Blob")) {
                handleChapter(1);
                return;
            }
        }
    }

    private void handleChapter(int chapter){
        ObjectMapper mapper = new ObjectMapper();
        File narrativeJson = new File(System.getProperty("user.dir") + "/src/main/" +
                "java/org/allyssinxd/zerodrpg/narrative/narrative.json");
        StringBuilder narrative = new StringBuilder();

        try {
            //Read All Narrative File
            Scanner scanner = new Scanner(narrativeJson);

            while(scanner.hasNextLine()) {
                narrative.append(scanner.nextLine());
            }

            List<Capter> listOfChapters = mapper.readValue(narrative.toString(), new TypeReference<List<Capter>>() {});
            String[] chapterByLines = listOfChapters.get(chapter).getText().split("\n");

            for (String line : chapterByLines) {
                TextUtils.typeText(line, 50);
                TextUtils.pause(1500);
            }

            for(String flag : listOfChapters.get(chapter).getFlags()){
                AddFlag(flag);
            }

            handleTrigger(listOfChapters.get(chapter).getTrigger());
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao ler arquivo json.");
        }  catch (FileNotFoundException e) {
            System.out.println("Erro ao ler arquivo inexistente.");
        }
    }

    private void handleTrigger(String trigger){
        if(trigger.equals("end-chapter-1")){
            setGameState(GameState.EXPLORATION);
            System.out.println("Iniciando jogabilidade capitulo 1");
            update();
        }
    }

    private void handleExploration(){
        if(getFlags().getLast().equals("inicio_jogo")){
            //Proxima escolha
        }
    }
}
