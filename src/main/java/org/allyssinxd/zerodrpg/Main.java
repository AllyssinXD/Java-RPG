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
        // Carregar jsons de saves
        TextUtils.typeText("SubVirus", 50);
        Choose menuChoices = new Choose();

        Game currentGame = null;
        final Action action = new Action();

        menuChoices.addOption(new ChooseOption("Novo Jogo", ()->action.d = "new"));
        menuChoices.addOption(new ChooseOption("Carregar Jogo", () ->action.d="load"));
        menuChoices.RunChoose();

        if(action.d.equals("new")) currentGame = Game.NewGame();
        else if(action.d.equals("load")) currentGame = Game.LoadGame(0);

        if (currentGame == null) return;
        currentGame.update();
    }


}
