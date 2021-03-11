package de.mlg.near.utils;

import org.bukkit.Material;

public class GeneralUtils {
    public static boolean containsCaseInsensitive(String s, String[] l){
        for (String string : l){
            if (string.equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }

    public static Material getMaterialFromString(String material) {
        if(containsCaseInsensitive("Wasser", new String[]{material}) || containsCaseInsensitive("Water", new String[]{material})) {
            return Material.WATER_BUCKET;
        }
        return Material.WATER_BUCKET;
    }

    public static int calcFallSeconds(int height) {
        int duration = 2;

        if (height > 50) {
            duration = 2;
        }
        if (height > 100) {
            duration = 5;
        }
        if (height > 200) {
            duration = 9;
        }
        if (height > 300) {
            duration = 10;
        }


        return duration + 2;
    }

}
