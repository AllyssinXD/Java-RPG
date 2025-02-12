package org.allyssinxd.zerodrpg.systems;

import org.allyssinxd.zerodrpg.Game;

public class BattleManager {

    private final Game game;

    public BattleManager(Game game){
        this.game = game;
    }

    public void HandleBattle(){
        game.setOver(false);
    }

}
