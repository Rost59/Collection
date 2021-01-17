package com.company;


import java.util.HashMap;

public class NumericalsOfAString {

    public static String numericals(String s) {
        //code here
        HashMap<Character, Integer> symbolFreq = new HashMap<>();
        String lowCaseStr = s.toLowerCase();
        String numStr = "";
        for (int i = 0; i < lowCaseStr.length(); i++) {
            int count = symbolFreq.getOrDefault(lowCaseStr.charAt(i), 0) + 1;
            symbolFreq.put(s.charAt(i), count);
            numStr += count;
        }

        return numStr;
    }
    public static void main(String[] args) {
        System.out.println(numericals("ВоттТ строккааа"));
    }
}
