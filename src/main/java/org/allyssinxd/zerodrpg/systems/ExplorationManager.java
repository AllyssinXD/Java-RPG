package org.allyssinxd.zerodrpg.systems;

import org.allyssinxd.zerodrpg.Game;
import org.allyssinxd.zerodrpg.Location;
import org.allyssinxd.zerodrpg.entities.Entity;
import org.allyssinxd.zerodrpg.utils.TextUtils;

public class ExplorationManager {

    private final Game game;

    public ExplorationManager(Game game){
        this.game = game;
    }

    public  void HandleExploration(){
        Location location = game.getLocation();

        System.out.println("----------- Exploração -------------");

        TextUtils.typeText("Elias agora está em " + location.getName() + ". " +
                location.getDescription());

        if(game.getFlags().getLast().equals("game_start")) TextUtils.typeText(
                "Apesar do lugar de onde aquele homem veio ser um mistério, Elias tem ideia de\n " +
                        "onde ele pode ter vindo, pois sabe que nesta floresta há alguns pontos interessantes para ser visitados. \n");

        if(!location.getPresentEntities().isEmpty()){
            if(location.getPresentEntities().size() > 1) TextUtils.typeText("Há algumas entidades aqui.");
            else TextUtils.typeText("Há alguma entidade aqui.");

            for(Entity entity : location.getPresentEntities()){
                TextUtils.typeText("Elias vê um(a) " + entity.getName());
            }
        }

        if(!location.getConnectionsIds().isEmpty()){
            for(String locationId : location.getConnectionsIds()){
                TextUtils.typeText("Você pode ir para " + Location.getLocationById(locationId).getName());
            }
        }

        TextUtils.typeText("O que ele vai fazer?", 50);

        Choose choose = new Choose();

        if(!location.getPresentEntities().isEmpty()){
            for(Entity entity : location.getPresentEntities()){
                choose.addOption(new ChooseOption("Ir até " + entity.getName(), ()->{
                    //Action
                }));
            }
        }

        if(!location.getConnectionsIds().isEmpty()){
            for(String locationId : location.getConnectionsIds()){
                choose.addOption(new ChooseOption("Ir para " + Location.getLocationById(locationId).getName(), ()->{
                    game.setLocation(Location.getLocationById(locationId));
                }));
            }
        }

        choose.RunChoose();
    }

}
