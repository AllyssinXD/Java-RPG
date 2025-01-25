package org.allyssinxd.zerodrpg;

import org.allyssinxd.zerodrpg.entity.Entity;
import org.allyssinxd.zerodrpg.utils.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {


    public static void NewGame()
    {
        TextUtils.typeText("Criando novo jogo...", 100);

        boolean cleanSlot = false;
        int i = 0;
        while (!cleanSlot) {
            File gameSaveFile = new File("./saves/slot"+i);
            if(!gameSaveFile.exists()) cleanSlot = true;
            i++;
        }

        try{
            File gameSaveFile = new File("./saves/slot"+i);
            gameSaveFile.createNewFile();
            Scanner scanner = new Scanner(gameSaveFile);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void LoadGame(){
        TextUtils.typeText("Carregando jogo...", 100);
    }

    private int slot;
}
