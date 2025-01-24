package org.allyssinxd.zerodrpg;

import org.allyssinxd.zerodrpg.systems.Choose;
import org.allyssinxd.zerodrpg.systems.ChooseOption;

public class Main {
    public static void main(String[] args){
        System.out.println("Carregando jogo...");
        // Carregar jsons de saves

        System.out.println("Subvirus");
        Choose menuChoices = new Choose();

        menuChoices.addOption(new ChooseOption("Novo Jogo", Game::NewGame));
        menuChoices.addOption(new ChooseOption("Carregar Jogo", Game::LoadGame));
        menuChoices.RunChoose();
    }
}
