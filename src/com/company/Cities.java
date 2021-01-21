package com.company;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Cities {


    static boolean checkCityLetter(String needCity, String city) {

        char cityChar = needCity.charAt(needCity.length() - 1);

        switch ((int) cityChar) {
            // код буквы 'ы'
            case 'ы':
                cityChar = needCity.charAt(needCity.length() - 2);
                break;
            // код буквы 'ь'
            case 'ь':
                cityChar = needCity.charAt(needCity.length() - 2);
                break;
            // код буквы 'й'
            case 'й':
                cityChar = 'и';
                break;
            // код буквы 'ё'
            case 'ё':
                cityChar = 'е';
                break;
        }

        return cityChar == city.charAt(0);
    }

    // mode (режим игры): 1 - с компьютером, 2 - с игроком
    static String findingCity(HashSet allCities, HashSet namedCities, String needCity, int step) {
        String city = "";
        Scanner scan = new Scanner(System.in);
        boolean notRightCity = true;
        if (step == 1) {
            Iterator<String> i = allCities.iterator();
            while (i.hasNext()) {
                city = i.next().toLowerCase();
                if (checkCityLetter(needCity, city) && !namedCities.contains(city)) {
                    System.out.println(city);
                    return city;
                }
            }
            return city = "Города с названиями, начинающмися на данную букву, отсутствуют";
        } else {
            do {
                System.out.println("Введите название города (или выход для окончания игры): ");
                city = scan.next().toLowerCase();

                if(city.equals("выход")){
                    break;
                }

                if (!allCities.contains(city)) {
                    System.out.println("Такой город не существует");
                    continue;
                }

                if (namedCities.contains(city)) {
                    System.out.println("Такой город уже был назван ранее");
                    continue;
                }

                notRightCity = !checkCityLetter(needCity, city);
            } while (notRightCity);
            return city;

        }

    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        // список всех городов
        HashSet<String> allCities = new HashSet<>();
        // для хранения уже использованных названий городов
        HashSet<String> namedCities = new HashSet<>();
        // 0 - ход игрока, 1 - ход компьютера
        int step = 0;
        String city = "Москва";

        System.out.println("Выберите режим игры: ");
        System.out.println("Цифра 1 - игра с компьютером, цифра 2 - игра с другим игроком");
        int mode = myScanner.nextInt();

        // для любого режима игры считываю названия городов из файла и записываю в HashSet
        try (Scanner scanner = new Scanner(new File("cities.txt"));) {
            while (scanner.hasNext()) {
                allCities.add(scanner.next().toLowerCase());
            }

        } catch (Exception exc) {

        }
        // если выбран режим игры с компьютером, то первый город всегда - Москва
        if (mode == 1) {
            System.out.println(city);
        } else {
            System.out.println("Введите название города (или выход для окончания игры): ");
            city = myScanner.next().toLowerCase();
            namedCities.add(city);
        }

        do {
            city = findingCity(allCities, namedCities, city, step % 2);
            // если выбран режим игры работы с компьютером, то значения step должны меняться (для перехода хода от компьютера к игроку и обратно)
            if (mode == 1) {
                step++;
            }
            namedCities.add(city.toLowerCase());
        } while (!city.toLowerCase().equals("выход"));


    }


}
