package com.company;


import java.util.*;

public class BracketsChecker {

    public static boolean checkBracketThree(String expression){
        Stack<Character> openBrackets = new Stack<>();
        Set<Character> openCharArray = new HashSet<>();
        Set<Character> closeCharArray = new HashSet<>();
        HashMap<Integer, Character> openCharArrayMap = new HashMap<>();
        HashMap<Integer, Character> closeCharArrayMap = new HashMap<>();

        Collections.addAll(openCharArray, '(', '[', '{');
        Collections.addAll(closeCharArray, ')', ']', '}');

        int j = 0;
        for (Character openChar : openCharArray) {
            openCharArrayMap.put(j, openChar);
            j++;
        }

        j = 0;
        for (Character closeChar : closeCharArray) {
            closeCharArrayMap.put(j, closeChar);
            j++;
        }

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (openCharArray.contains(c))
                openBrackets.push(c);
            else if (closeCharArray.contains(c)) {
                if (openBrackets.empty())
                    return false;

                char openBracket = openBrackets.pop();




                for (int k = 0; k < openCharArray.size(); k++) {
                    if (openCharArrayMap.get(k).equals(openBracket) && !closeCharArrayMap.get(k).equals(c))
                        return false;
                }
            }
        }
        return openBrackets.empty();



      //  openCharArrayMap.put(1, )


    }

    // ф-ия выполняет то же самое что и checkBracket, но с использованием ArrayList()
    public static boolean checkBracketTwo(String expression) {
        Stack<Character> openBrackets = new Stack<>();
        List<Character> openCharArray = new ArrayList<>();
        List<Character> closeCharArray = new ArrayList<>();

        Collections.addAll(openCharArray, '(', '[', '{');
        Collections.addAll(closeCharArray, ')', ']', '}');

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (openCharArray.contains(c))
                openBrackets.push(c);
            else if (closeCharArray.contains(c)) {
                if (openBrackets.empty())
                    return false;

                char openBracket = openBrackets.pop();
                for (int j = 0; j < openCharArray.size(); j++) {
                    if (openCharArray.get(j).equals(openBracket) && !closeCharArray.get(j).equals(c))
                        return false;
                }
            }
        }
        return openBrackets.empty();
    }




    public static boolean checkBracket(String expression) {
        Stack<Character> openBrackets = new Stack<>();
        //Использую TreeSet для сохранения элементов в порядке вставки
        Set<Character> brackets1 = new TreeSet<>();
        brackets1.add('(');
        brackets1.add('[');
        brackets1.add('{');
        Set<Character> brackets2 = new TreeSet<>();
        brackets2.add(')');
        brackets2.add(']');
        brackets2.add('}');


        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (brackets1.contains(c))
                openBrackets.push(c);
            else if (brackets2.contains(c)) {
                if (openBrackets.empty())
                    return false;

                char openBracket = openBrackets.pop();
                int j = 0;
                for (Character p : brackets1) {
                    j++;
                    if (p.equals(openBracket))
                        break;
                }
                int k = 0;
                for (Character p : brackets2) {
                    k++;
                    if ((k == j) && !(p.equals(c)))
                        return false;

                }

            }
        }


        return openBrackets.empty();
    }

    public static void main(String[] args) {
        String expression = "({}])()";
      //  System.out.println(checkBracket(expression));
        System.out.println(checkBracketThree(expression));
    }
}