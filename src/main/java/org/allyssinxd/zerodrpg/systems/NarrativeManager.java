package org.allyssinxd.zerodrpg.systems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.allyssinxd.zerodrpg.Chapter;
import org.allyssinxd.zerodrpg.Game;
import org.allyssinxd.zerodrpg.utils.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class NarrativeManager {

    private static final String localStorage =
            "%s/src/main/java/org/allyssinxd/zerodrpg".formatted(System.getProperty("user.dir"));

    private final Game game;

    public NarrativeManager(Game game){
        this.game = game;
    }

    public void HandleNarrative(){
        HandleChapter(game.getChapter());
    }

    private void HandleChapter(int chapter){
        File narrativeJson = new File(localStorage + "/narrative/narrative.json");
        StringBuilder narrative = new StringBuilder();

        try {
            //Read All Narrative File
            Scanner scanner = new Scanner(narrativeJson);

            while(scanner.hasNextLine()) {
                narrative.append(scanner.nextLine());
            }

            //Transform to Object
            ObjectMapper mapper = new ObjectMapper();
            List<Chapter> listOfChapters = mapper.readValue(narrative.toString(), new TypeReference<List<Chapter>>() {});

            //Read Narrative to Player
            String[] chapterByLines = listOfChapters.get(chapter).getText().split("\n");
            for (String line : chapterByLines) {
                TextUtils.typeText(line, 10);
                TextUtils.pause(1500);
            }

            //Add trigger and flags
            for(String flag : listOfChapters.get(chapter).getFlags()){
                game.AddFlag(flag);
            }

            game.triggerManager.RunTrigger(listOfChapters.get(chapter).getTrigger());
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao ler arquivo json.");
        }  catch (FileNotFoundException e) {
            System.out.println("Erro ao ler arquivo inexistente.");
        }
    }
}
