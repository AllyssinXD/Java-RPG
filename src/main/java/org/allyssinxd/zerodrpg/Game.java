package org.allyssinxd.zerodrpg;

import org.allyssinxd.zerodrpg.entity.Entity;
import org.allyssinxd.zerodrpg.utils.TextUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {


    public static void NewGame()
    {
        TextUtils.typeText("Criando novo jogo...", 100);

        System.out.println(System.getProperty("user.dir"));

        boolean cleanSlot = false;
        int i = 0;
        File gameSaveFile = new File("");
        while (!cleanSlot) {
            gameSaveFile = new File(System.getProperty("user.dir") + "/saves/slot"+i+".json");
            if(!gameSaveFile.exists()) cleanSlot=true;
            i++;
        }
        try{
            if(gameSaveFile.createNewFile())
                System.out.println("Novo jogo criado no Slot " + i);
        } catch (Exception e){
            System.out.println(e.toString());
        }


    }

    public static void LoadGame(){
        TextUtils.typeText("Carregando jogo...", 100);
    }

    private int slot;
}
