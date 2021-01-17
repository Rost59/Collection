package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.*;


public class Sales {
// Добавлен комментарий//

    static Map<String, Map<String, Integer>> saleSort(String[] statistics){
        Map<String, Map<String, Integer>> buyerAndProduct = new TreeMap<>();
        Map<String, Integer> productAndCount;
        String[] concreteStatistic;

        for (int i = 0; i < statistics.length; i++) {
            concreteStatistic = statistics[i].split(" ");
            String nameClient = concreteStatistic[0];
            String nameProduct = concreteStatistic[1];
            int countProduct = Integer.parseInt(concreteStatistic[2]);

            if(buyerAndProduct.containsKey(nameClient)){
                productAndCount = buyerAndProduct.get(nameClient);
                int countProductTotal = productAndCount.getOrDefault(nameProduct, 0) + countProduct;
                productAndCount.put(nameProduct, countProductTotal);

            } else{
                productAndCount = new TreeMap<>();
                productAndCount.put(nameProduct, countProduct);
                buyerAndProduct.put(nameClient, productAndCount);
            }


        }

        return buyerAndProduct;
    }

    public static void main(String[] args) {

        String [] buyerInfo = new String[6];
        buyerInfo[0] = "Ivanov paper 10";
        buyerInfo[1] = "Petrov pens 5";
        buyerInfo[2] = "Ivanov marker 3";
        buyerInfo[3] = "Ivanov paper 7";
        buyerInfo[4] = "Petrov envelope 20";
        buyerInfo[5] = "Ivanov envelope 5";
        saleSort(buyerInfo);

        System.out.println(saleSort(buyerInfo));

    }


}
