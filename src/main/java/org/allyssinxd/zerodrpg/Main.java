package org.allyssinxd.zerodrpg;

import org.allyssinxd.zerodrpg.systems.Choose;
import org.allyssinxd.zerodrpg.systems.ChooseOption;
import org.allyssinxd.zerodrpg.utils.TextUtils;

public class Main {
    public static void main(String[] args){
        TextUtils.typeText(".\n.\n.\n.\n.\n", 300);
        // Carregar jsons de saves
        TextUtils.typeText("SubVirus", 300);
        Choose menuChoices = new Choose();

        menuChoices.addOption(new ChooseOption("Novo Jogo", Game::NewGame));
        menuChoices.addOption(new ChooseOption("Carregar Jogo", Game::LoadGame));

        menuChoices.RunChoose();
    }
}
