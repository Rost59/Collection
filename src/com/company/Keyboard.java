package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Keyboard {

    static HashMap<Integer, Integer> countingOfClicks(int[] orderOfClicks){
        HashMap<Integer, Integer> countOfClicks = new HashMap<>();
        for (int i = 0; i < orderOfClicks.length; i++) {
            int count = countOfClicks.getOrDefault(orderOfClicks[i], 0) + 1;
            countOfClicks.put(orderOfClicks[i], count);

        }
        return countOfClicks;
    }

    static String[] keyboardTest(HashMap<Integer, Integer> countOfClicks, int[] maxNumberOfClicks){

        String[] result = new String[maxNumberOfClicks.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> pair : countOfClicks.entrySet()) {

            if(pair.getValue() > maxNumberOfClicks[i]){
                result[i] = "yes";
            } else{
                result[i] = "no";
            }
            i++;
        }
        return result;
    }

    static void recordFile(String[] result, String fileName){
        try(PrintWriter out = new PrintWriter(fileName)){

            for (int i = 0; i < result.length; i++) {
                out.write(result[i]);
                out.write("\n");
            }

        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }

// Комментарий/
    public static void main(String[] args) {

        String []  result;

        try (Scanner scanner = new Scanner(new File("input.txt"))) {

            //количество нажатий каждой клавиши
            int [] maxNumberOfClicks = new int[scanner.nextInt()];

            for (int i = 0; i < maxNumberOfClicks.length; i++) {
                maxNumberOfClicks[i] = scanner.nextInt();
            }

            // общее кол-во нажатий клавиш
            int countOfClicks = scanner.nextInt();
            // последовательность нажатий клавиш
            int[] orderOfClicks = new int[countOfClicks];

            for (int i = 0; i < countOfClicks; i++) {
                orderOfClicks[i] = scanner.nextInt();
            }

            result = keyboardTest (countingOfClicks(orderOfClicks), maxNumberOfClicks);
            recordFile(result, "result.txt");

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

    }
}
