package org.allyssinxd.zerodrpg.systems;

import org.allyssinxd.zerodrpg.Game;
import org.allyssinxd.zerodrpg.GameState;
import org.allyssinxd.zerodrpg.Location;

public class TriggerManager {

    private final Game game;

    public TriggerManager(Game game){
        this.game = game;
    }

    public void RunTrigger(String trigger){
        if(trigger.equals("end-of-introduction")){
            game.setGameState(GameState.EXPLORATION);
            game.setLocation(Location.getLocationById("CorvellanFlorest"));
        }
    }

}
