package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences){

        HashMap<Integer, Integer> pictureNumAndCol = new HashMap<>();
        ArrayList <Integer>sortedElements = new ArrayList<>();


        for (int i = 0; i < elements.length; i++) {
            int count = pictureNumAndCol.getOrDefault(elements[i], 0) + 1;
            pictureNumAndCol.put(elements[i], count);
            if (count <= maxOccurrences){
                sortedElements.add(elements[i]);
            }
        }


        Integer [] result = sortedElements.toArray(new Integer[sortedElements.size()]);
        int resultInt [] = Arrays.stream(result).mapToInt(i->i).toArray();



        return resultInt;

    }


    public static void main(String[] args) {


        int[] a = deleteNth(new int[] {20,37,20,21}, 1);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
       // System.out.println(a.toString());
    }
}
