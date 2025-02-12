package org.allyssinxd.zerodrpg;

import org.allyssinxd.zerodrpg.entities.Entity;
import org.allyssinxd.zerodrpg.systems.Inventory;

import java.util.ArrayList;
import java.util.Collection;

public class Location {

    private String id;
    private String name;
    private String description;

    private ArrayList<String> connectionsIds;
    private ArrayList<Entity> presentEntities;
    private Inventory items;

    public Location(String id, String name, String description,
                    ArrayList<Entity> presentEntities, Inventory items, ArrayList<String> connectionsIds){
        this.id = id;
        this.name = name;
        this.description = description;
        this.presentEntities = presentEntities;
        this.items = items;
        this.connectionsIds = connectionsIds;
    }

    public static Location getLocationById(String id){
        if(id.equals("CorvellanFlorest")){
            return new Location(
                    "CorvellanFlorest",
                    "Floresta de Corvellan",
                    "Uma floresta perto de seu vilarejo, Corvellan.",
                    new ArrayList<Entity>(),
                    new Inventory(),
                    new ArrayList<String>(){{
                        add("CorvellanVillage");
                        add("FlorestWaterfall");
                        add("AbandonedCave");
                    }}
            );
        }

        if(id.equals("CorvellanVillage")){
            return new Location(
                    "CorvellanVillage",
                    "Vilarejo de Corvellan",
                    "Corvellan é um vilarejo sombrio, cercado por florestas que escondem o horizonte. O lugar está desgastado pelo tempo,\n suas casas de madeira apodrecendo e as ruas vazias exceto por alguns moradores que parecem desconfiados de forasteiros.",
                    new ArrayList<Entity>(),
                    new Inventory(),
                    new ArrayList<String>(){{
                        add("CorvellanFlorest");
                    }}
            );
        }

        if(id.equals("FlorestWaterfall")){
            return new Location(
                    "FlorestWaterfall",
                    "Riacho Escondido",
                    "Por mais calmo que o riacho pareça, há uma tensão no ar – uma sensação de que algo \n ou alguém está observando.",
                    new ArrayList<Entity>(),
                    new Inventory(),
                    new ArrayList<String>(){{
                        add("CorvellanFlorest");
                    }}
            );
        }

        if(id.equals("AbandonedCave")){
            return new Location(
                    "AbandonedCave",
                    "Caverna Abandonada",
                    "A caverna é uma fenda na rocha coberta por raízes e musgo, com uma entrada que parece repelir a luz do sol. Seu interior é escuro e frio, com o som ocasional de gotas ecoando pelo espaço. Criaturas desconhecidas habitam suas profundezas, mas também há promessas de descobertas que podem ajudar Elias em sua jornada, como uma lanterna para iluminar os caminhos futuros.",
                    new ArrayList<Entity>(),
                    new Inventory(),
                    new ArrayList<String>(){{
                        add("CorvellanFlorest");
                    }}
            );
        }

        return null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Entity> getPresentEntities() {
        return presentEntities;
    }

    public Inventory getItems() {
        return items;
    }

    public ArrayList<String> getConnectionsIds() {
        return connectionsIds;
    }
}
