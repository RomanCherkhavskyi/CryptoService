package org.example;


import org.example.functions.Calculate;
import org.example.functions.UserDataCheck;

import java.util.Scanner;

public class Main {


    //what about creator pattern (GRASP)? 
    //why we declarated variables at the beginning of the method and not where it are actually needed?
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number about currency you need\n1:BTC, 2:ETH, 3:DOGE, 4:LTC, 5:XRP");
        int selectCurrency = Integer.parseInt(scanner.nextLine());
        if (!new UserDataCheck().currencyCheck(selectCurrency)) return;


        System.out.println("Please enter a start date and time in next format: yyyy-MM-dd'T'HH:mm");
        String startDate = scanner.nextLine();
        if (!new UserDataCheck().dateCheck(startDate)) return;


        System.out.println("Please enter a finish date in next format: yyyy-MM-dd'T'HH:mm");
        String finishDate = scanner.nextLine();
        if (!new UserDataCheck().dateCheck(finishDate)) return;


        System.out.println("Please select what you need calculate:\n1:min, 2:max, 3:middle, 4:normal");
        int selectFunction = Integer.parseInt(scanner.nextLine());
        if (!new UserDataCheck().functionCheck(selectFunction)) return;

        System.out.println(new Calculate().calculateUserNeed(selectCurrency,
                startDate,
                finishDate,
                selectFunction));
    }
}