package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Metro {


    static String nextStation(ArrayList<String> metroStation, String currentStation, Integer direction){

        int stationIndex = metroStation.indexOf(currentStation);

        return direction == 1 ?  metroStation.get(++stationIndex) :  metroStation.get(--stationIndex);

    }


    public static void main(String[] args) {


        ArrayList<String> metroStation = new ArrayList<>(Arrays.asList("Заельцовская", "Гагаринская", "Красный проспект", "Площадь Ленина", "Октябрьская", "Речной Вокзал", "Студенческая", "Площадь Маркса", "Площадь Гарина-Михайловского", "Сибирская", "Маршала Покрышкина", "Березовая Роща", "Золотая Нива"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название текущей станции: ");
        String stationName = scanner.nextLine();
        System.out.println("Введите направление движения: 1 - с севера на юг или с запада на восток, 2 - с юга на север или с востока на запад");
        String direction = scanner.nextLine();

        System.out.println(nextStation(metroStation, stationName, Integer.parseInt(direction)));




    }

}
