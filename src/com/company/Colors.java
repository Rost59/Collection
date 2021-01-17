package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Colors {
    // и еще комментарий
    // Еще комментарий
    // ДОБАВЛЯЮ КОММЕНТАРИЙ

    // поиск ключа по значению
    static String getKeyToValue(HashMap<String, String> colors, String value){
        String result = "";
        for (Map.Entry<String, String> pair: colors.entrySet()) {
            if(pair.getValue().equals(value)){
                result = pair.getKey();
                break;
            }
        }
        return result;
    }

    // перевод цветов изображения в негатив
    static String[] revertCol(String[] colors){
        HashMap<String, String> revColors = new HashMap<>();
        revColors.put("white", "black");
        revColors.put("red", "green");
        revColors.put("yellow", "blue");
        String[] resultColors = new String[colors.length];

        for (int i = 0; i < colors.length; i++) {
            if(revColors.containsKey(colors[i])){
                resultColors[i] = revColors.get(colors[i]);
            } else {
                resultColors[i] = getKeyToValue(revColors, colors[i]);
            }
        }
        return resultColors;
    }


    public static void main(String[] args) {
        String[] colors = {"white", "red", "black", "green", "yellow", "blue"};
        String[] resultColors = revertCol(colors);
        for (int i = 0; i < resultColors.length; i++) {
            System.out.println(resultColors[i]);
        }


    }
}
