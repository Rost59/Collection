package com.company;

import java.util.ArrayList;
import java.util.*;


public class VotingInUSA {

    public static String voiting(String[] stateResult){
        // Для того, чтобы фамилии (ключи) были отсортированы по возрастанию, использовал класс TreeMap
        Map <String, Integer> allCandidates = new TreeMap<>();
      //  HashMap<String, ArrayList<Integer>>aC = new HashMap<>();

        String result = "";
        // candidate[0] - фамилия кандидата,  candidate[1] - кол-во голосов отданных за кандидата в штате
        String[]  candidate = new String[2];
        Integer voices;
        String candidateName;
        for (int i = 1; i < stateResult.length; i++) {
            candidate = stateResult[i].split(" ");
            candidateName = candidate[0];
            voices = Integer.parseInt(candidate[1]);
            int totalVoices = allCandidates.getOrDefault(candidateName, 0) + voices;

            allCandidates.put(candidateName, totalVoices);
        }


        for (  Map.Entry<String, Integer> pair  : allCandidates.entrySet()) {
            result += pair.getKey() + " - " + pair.getValue() + ";\n";
          //  allCandidates.get
        }

      /*char ch = 'a';
        for (int i = 0; i < allCandidates.size(); i++) {
            ch = allCandidates.get(i).toString().charAt(0);
            ch = allCandidates.get
        }*/



        return result;
    }

    public static void main(String[] args) {

        String [] stateResult = {"7", "McCain 10", "McCain 5", "Obama 9", "Obama 8", "McCain 1", "Anderson 5", "Nobel 37"};
        String [] stateResult1 = {"13", "McCain 10", "McCain 3", "Obama 19", "Obama 2", "McCain 7", "McCain 2", "Obama 6", "Obama 10", "McCain 11", "McCain 5", "Obama 3", "Obama 12", "McCain 13"};
        String [] stateResult2 = {"7", "ivan 2", "gena 1", "sergey 100000", "ivan 1", "ivan 1", "ivan 0", "gena 100"};
        System.out.println(voiting(stateResult));

      //  System.out.println((int)'c');
    }
}


