package org.allyssinxd.zerodrpg.utils;

public class TextUtils {

    public static boolean fastFoward = true;

    public static void typeText(String text, int delay){
        if(fastFoward) {
            System.out.println(text);
            return;
        }

        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void typeText(String text){
        if(fastFoward) {
            System.out.println(text);
            return;
        }

        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void pause(long duration) {
        if (fastFoward) duration = 1;
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
