package org.allyssinxd.zerodrpg;

import org.allyssinxd.zerodrpg.entity.Entity;
import org.allyssinxd.zerodrpg.utils.TextUtils;

import java.util.ArrayList;

public class Game {


    public static void NewGame(){
        TextUtils.typeText("Criando novo jogo...", 100);
    }

    public static void LoadGame(){
        System.out.println("---------- Carregando jogo. ----------");
    }

    private int slot;

}
