package org.allyssinxd.zerodrpg;
import org.allyssinxd.zerodrpg.systems.*;
import org.allyssinxd.zerodrpg.utils.Action;
import org.allyssinxd.zerodrpg.utils.TextUtils;

public class Main {
    public static void main(String[] args){
        TextUtils.typeText("SubVirus", 50);

        Choose menuChoices = new Choose();
        final Action action = new Action();
        menuChoices.addOption(new ChooseOption("Novo Jogo", ()->action.d = "new"));
        menuChoices.addOption(new ChooseOption("Carregar Jogo", () ->action.d="load"));
        menuChoices.RunChoose();

        Game currentGame = null;
        if(action.d.equals("new")) currentGame = Game.NewGame();
        else if(action.d.equals("load")) currentGame = Game.LoadGame(0);
        if (currentGame == null) return;

        while(!currentGame.isOver()){
            /*
            if(currentGame.getActiveTrigger() != null) {
                Handle trigger
            }
            */

            switch (currentGame.getGameState()){
                case NARRATIVE -> currentGame.narrativeManager.HandleNarrative();
                case EXPLORATION -> currentGame.explorationManager.HandleExploration();
                case BATTLE -> currentGame.battleManager.HandleBattle();
            }

        }
    }


}
