package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixNotation {


    static int  expressionOperation(String firstValue, String secondValue, String operation){
        int result = 0;
        int intFirstValue = Integer.parseInt(firstValue);
        int intSecondValue = Integer.parseInt(secondValue);

        switch (operation){
            case("+") : result = intSecondValue + intFirstValue; break;
            case("-") : result = intSecondValue - intFirstValue; break;
            case("*") : result = intSecondValue * intFirstValue; break;
            case("/") : result = intSecondValue / intFirstValue; break;
        }

        return result;
    }

    public static void main(String[] args) {

        String postfixStr = "1 2 3 5 * + -";
        String[] values = postfixStr.split(" ");
        Stack<String> expression = new Stack<>();

        for (int i = 0; i < values.length; i++) {
         //   Character ch = postfixStr.charAt(i);
            if(!values[i].equals("+") && !values[i].equals("-") && !values[i].equals("*") && !values[i].equals("/")){
               // System.out.println(postfixStr.charAt(i) + ", код = " );
                expression.push(values[i]);
            } else {
                String firstValue = expression.pop();
                String secondValue = expression.pop();
                int result = expressionOperation(firstValue, secondValue, values[i]);
                expression.push(Integer.toString(result));
            }
        }
        System.out.println(expression.pop());

    }

}
