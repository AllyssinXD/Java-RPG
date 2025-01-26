package org.allyssinxd.zerodrpg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.allyssinxd.zerodrpg.systems.Choose;
import org.allyssinxd.zerodrpg.systems.ChooseOption;
import org.allyssinxd.zerodrpg.utils.Action;
import org.allyssinxd.zerodrpg.utils.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TextUtils.typeText(".\n.\n.\n.\n.\n", 300);
        // Carregar jsons de saves
        TextUtils.typeText("SubVirus", 300);
        Choose menuChoices = new Choose();

        Game currentGame = null;
        final Action action = new Action();

        menuChoices.addOption(new ChooseOption("Novo Jogo", ()->action.d = "new"));
        menuChoices.addOption(new ChooseOption("Carregar Jogo", () ->action.d="load"));
        menuChoices.RunChoose();

        if(action.d.equals("new")) currentGame = Game.NewGame();
        else if(action.d.equals("load")) currentGame = Game.LoadGame(0);

        if(currentGame.getChapter() == 0){
            ObjectMapper mapper = new ObjectMapper();

            File narrativeJson = new File(System.getProperty("user.dir") + "/src/main/" +
                    "java/org/allyssinxd/zerodrpg/narrative/narrative.json");
            StringBuilder narrative = new StringBuilder();
            try {
                Scanner scanner = new Scanner(narrativeJson);
                while(scanner.hasNextLine()){
                    narrative.append(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                List<Capter> list = mapper.readValue(narrative.toString(), new TypeReference<List<Capter>>() {});

                String[] splitedByLines = list.getFirst().getText().split("\n");
                for (int j = 0; j < splitedByLines.length; j++) {
                    TextUtils.typeText(splitedByLines[j], 50);
                    TextUtils.pause(1500);
                }

                for(String flag : list.getFirst().getFlags()){
                    currentGame.AddFlag(flag);
                }


            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
