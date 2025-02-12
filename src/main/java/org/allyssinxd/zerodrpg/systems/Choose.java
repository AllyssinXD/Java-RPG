package org.allyssinxd.zerodrpg.systems;

import java.util.ArrayList;
import java.util.Scanner;

public class Choose {
    private final ArrayList<ChooseOption> options = new ArrayList<>();

    public void addOption (ChooseOption newOption){
        options.add(newOption);
    }

    public void ShowOptions (){
        if(options.isEmpty()) return;
        System.out.println("---------- Faça sua Escolha -----------");
        for (int count = 0; count < options.size(); count++){
            System.out.println((count+1) + " : " + options.get(count).title);
        }
        System.out.println("(Escolha entre 1 à " + options.size() + ")");
    }

    public void RunChoose (){
        Scanner scanner = new Scanner(System.in);
        boolean ended = false;

        while(!ended) {
            ShowOptions();
            if (!scanner.hasNextInt()) return;
            int choose = scanner.nextInt();
            if (choose > options.size() || choose <= 0) {
                System.out.println("!          Escolha inválida       !");
            } else {
                options.get(choose - 1).execute();
                ended = true;
            }
        }

        //scanner.close();
    }
}
