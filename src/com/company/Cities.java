package com.company;

import java.io.File;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Cities {

    //комментарий
    static boolean checkCityLetter(String firstCity, String secondCity){
        char cityChar = firstCity.charAt(firstCity.length()-1);

        switch ((int)cityChar){
            // код буквы 'ы'
            case 1099 : cityChar = firstCity.charAt(firstCity.length()-2); break;
            // код буквы 'ь'
            case 1100 : cityChar = firstCity.charAt(firstCity.length()-2); break;
            // код буквы 'й'
            case 1081 : cityChar = 'и'; break;
            // код буквы 'ё'
            case 1105 : cityChar = 'е'; break;
        }

       return cityChar == secondCity.charAt(0);
    }

    // mode (режим игры): 1 - с компьютером, 2 - с игроком
    static String findingCity(Scanner scan, int mode, String secondCity, HashSet namedCities){
        String city = "";
        if(mode == 1){
            while (scan.hasNext()){
                city = scan.nextLine();
                if (checkCityLetter(secondCity, city) && !namedCities.contains(city)){
                    return city;
                }
            }
            return city = "Города с названиями, начинающмися на данную букву, отсутствуют";
        } else {
            do {
                System.out.println("Второй игрок, введите название города (или выход для окончания игры): ");
                city = scan.next();
            }while ((checkCityLetter(city, secondCity) && !namedCities.contains(city))||city.toLowerCase().equals("выход"));
            return city;

        }

    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //для хранения уже использованных названий городов
        HashSet<String> namedCities = new HashSet<>();

        System.out.println("Выберите режим игры: ");
        System.out.println("Цифра 1 - игра с компьютером, цифра 2 - игра с другим игроком");
        int mode = myScanner.nextInt();
        String city = "";


        try (Scanner scanner = new Scanner(new File("cities.txt"));){


            int k = 0;
            do {
                // выбран режим игры с компьютером
                if (mode == 1) {
                    if (k == 0) {
                        Random rand = new Random();
                        for (int i = 0; i < rand.nextInt(10); i++) {
                            scanner.nextLine();
                        }
                        city = scanner.nextLine();
                        namedCities.add(city);
                        System.out.println(city);

                    } else {
                        city = findingCity(scanner, mode, city, namedCities);
                        namedCities.add(city);
                        System.out.println(city);
                    }
                    k++;
                } else{

                    System.out.println("Введите название города (или выход для окончания игры): ");
                    city = myScanner.next();
                    if(city.toLowerCase().equals("выход")){
                        break;
                    }
                    namedCities.add(city);
                    city = findingCity(scanner, mode, city, namedCities);


                }

                k++;
            } while (!city.toLowerCase().equals("выход"));




        } catch(Exception exception){

        }
    }


}
