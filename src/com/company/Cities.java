package com.company;

import java.io.File;
import java.util.*;

public class Cities {


    static char checkCityLetter(String needCity) {

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

        return cityChar;
    }

    // поиск города компьютером
    public static String computerStep(Map<Character, ArrayList<String>> firstLetterCities, Set<String> namedCities, String needCity){
        String city = "Игра закончена. Города, с названиями начинающмися на данную букву, отсутствуют.";
        // буква на которую должен начинаться искомый город
        char needLetter = checkCityLetter(needCity);
        // список всех городов, начинающихся на искомую букву
        ArrayList<String> cities = firstLetterCities.get(needLetter);

        if (cities == null){
            return city;
        }
        for (String s : cities) {
            if (!namedCities.contains(s)) {
                city = s;
                // namedCities.add(city); если раскомментировать эту строку, то namedCities, объявленный в main, будет меняться
                break;
            }
        }

        return city;
    }

    public static String personStep(Map<Character, ArrayList<String>> firstLetterCities, Set<String> namedCities, String needCity, String personName){
        String city = "";
        Scanner scan = new Scanner(System.in);
        boolean notRightCity = true;
        // буква на которую должен начинаться искомый город
        char needLetter = checkCityLetter(needCity);
        // список всех городов, начинающихся на искомую букву
        ArrayList<String> cities = firstLetterCities.get(needLetter);

        if (cities == null){
            city = "Игра закончена. Города, с названиями начинающмися на данную букву, отсутствуют.";
            return city;
        }
        do {
            System.out.println(personName + " введите название города (или выход для окончания игры): ");
            city = scan.nextLine().toLowerCase();

            if(city.equals("выход")){
                break;
            }

            if (needLetter != city.charAt(0)) {
                System.out.println("Нужно написать город, начинающийся на букву " + needLetter);
                continue;
            }

            if (!cities.contains(city)) {
                System.out.println("Такой город не существует");
                continue;
            }

            if (namedCities.contains(city)) {
                System.out.println("Такой город уже был назван ранее");
                continue;
            }
            notRightCity = false;

        } while (notRightCity);
        return city;
    }




    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        // список всех городов
        Set<String> allCities = new TreeSet<>();
        // для хранения уже использованных названий городов
        HashSet<String> namedCities = new HashSet<>();
        int step = 0;
        int mode = 1;
        String city = "";
        String firstPersonName = "", secondPersonName = "";

        System.out.println("Выберите режим игры: ");
        System.out.println("Цифра 1 - игра с компьютером, цифра 2 - игра с другим игроком");

        try {
            mode = myScanner.nextInt();
        } catch (Exception exc){
            System.out.println("Вы ввели число отличное от 1 и 2. По умолчанию выбран режим игры с компьютером");
            myScanner.nextLine();
        }
        // для любого режима игры считываю названия городов из файла и записываю в HashSet
        try (Scanner scanner = new Scanner(new File("cities.txt"));) {
            while (scanner.hasNext()) {
                allCities.add(scanner.nextLine().toLowerCase());
            }

        } catch (Exception exc) {
            System.out.println(exc);
        }

        char letter = 'а';
        ArrayList<String> equalLetterCities = new ArrayList<>();
        Map<Character, ArrayList<String>> firstLetterCities= new TreeMap<>();
        // создания словаря: ключ - первая буква в названии города, значение - массив городов, начинающихся на эту букву
        for (String allCity : allCities) {
            city = allCity.toLowerCase();
            if (city.charAt(0) != letter) {
                firstLetterCities.put(letter, (ArrayList<String>) equalLetterCities.clone());
                letter = city.charAt(0);
                equalLetterCities.clear();
            }
            equalLetterCities.add(city);

        }

        firstLetterCities.put(letter, (ArrayList<String>) equalLetterCities.clone());

        System.out.println("Первый игрок введите ваше имя: ");
        myScanner.nextLine();
        firstPersonName = myScanner.nextLine();

        // если mode = 2, то выбран режим игры со вторым игроком
        if(mode == 2){
            System.out.println("Второй игрок введите ваше имя: ");
            secondPersonName = myScanner.nextLine();
        }

        System.out.println(firstPersonName + " введите название города (или выход для окончания игры): ");
        city = myScanner.nextLine().toLowerCase();

        while(!allCities.contains(city)){
            System.out.println("Такой город не существует");
            System.out.println(firstPersonName + " введите название города (или выход для окончания игры): ");
            city = myScanner.nextLine().toLowerCase();
        }

        namedCities.add(city);

        do {
            // если mode = 1, то выбран режим игры с компьютером
            if (mode == 1) {
                // step % 2 == 0 - ход игрока, иначе - ход компьютера
                if (step % 2 == 0){
                    city = computerStep(firstLetterCities, namedCities, city);
                    System.out.println(city);
                } else{
                    city = personStep(firstLetterCities, namedCities, city, firstPersonName);
                }

            } else{
                if (step % 2 == 0) {
                    city = personStep(firstLetterCities, namedCities, city, secondPersonName);

                } else{
                    city = personStep(firstLetterCities, namedCities, city, firstPersonName);
                }
            }
            step++;
            namedCities.add(city.toLowerCase());
        } while (!city.toLowerCase().equals("выход") && (!city.contains("Игра закончена")));


    }


}
