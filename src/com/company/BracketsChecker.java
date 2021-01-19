package com.company;

import java.util.Stack;

public class BracketsChecker {

    public static boolean checkBracket(String expression){
        Stack<Character> openBrackets = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                openBrackets.push(c);
            else if (c == ')' || c == ']' || c == '}')
            {
                if (openBrackets.empty())
                    return false;
                char openBracket = openBrackets.pop();
                if (openBracket == '(' && c != ')')
                    return false;
                if (openBracket == '[' && c != ']')
                    return false;
                if (openBracket == '{' && c != '}')
                    return false;
            }
        }
        return openBrackets.empty();
    }

    public static void main(String[] args) {
        String expression = "({}[])()";
        System.out.println(checkBracket(expression));

    }
}