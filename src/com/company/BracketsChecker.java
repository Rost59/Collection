package com.company;


import java.util.*;

public class BracketsChecker {

    public static boolean checkBracket(String expression){
        Stack<Character> openBrackets = new Stack<>();
        Set<Character> openCharArray = new HashSet<>();
        Set<Character> closeCharArray = new HashSet<>();
        HashMap<Character, Character> charArrayMap = new HashMap<>();

        charArrayMap.put(')', '(');
        charArrayMap.put(']', '[');
        charArrayMap.put('}', '{' );

      //  charArrayMap.co



        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (charArrayMap.containsValue(c))
                openBrackets.push(c);
            else if (charArrayMap.containsKey(c)) {
                if (openBrackets.empty())
                    return false;

                char openBracket = openBrackets.pop();

                if (charArrayMap.getOrDefault(c, '1') != openBracket){
                    return false;
                }


            }
        }
        return openBrackets.empty();


    }


    public static void main(String[] args) {
        String expression = "({})}()";
      //  System.out.println(checkBracket(expression));
        System.out.println(checkBracket(expression));
    }
}