package org.allyssinxd.zerodrpg.systems;

public class ChooseOption {
    public String title = "...";
    public Runnable action;

    public ChooseOption(String title, Runnable action){
        this.title = title;
        this.action = action;
    }

    public void execute(){
        action.run();
    }
}
