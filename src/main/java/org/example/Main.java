package org.example;


import org.example.functions.Calculate;
import org.example.functions.UserDataCheck;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int choiceCurrency;
        String startDate;
        String finishDate;
        int choiceFunction;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number about currency you need" + "\n" +
                "1:BTC, 2:ETH, 3:DOGE, 4:LTC, 5:XRP");
        choiceCurrency = Integer.parseInt(scanner.nextLine());
        if (!new UserDataCheck().currencyCheck(choiceCurrency)) return;


        System.out.println("Please enter a start date and time in next format: yyyy-MM-dd'T'HH:mm");
        startDate = scanner.nextLine();
        if (!new UserDataCheck().dateCheck(startDate)) return;


        System.out.println("Please enter a finish date in next format: yyyy-MM-dd'T'HH:mm");
        finishDate = scanner.nextLine();
        if (!new UserDataCheck().dateCheck(finishDate)) return;


        System.out.println("Please select what you need calculate:" + "\n" +
                "1:min, 2:max, 3:middle, 4:normal");
        choiceFunction = Integer.parseInt(scanner.nextLine());
        if (!new UserDataCheck().functionCheck(choiceFunction)) return;

        System.out.println(new Calculate().calculateUserNeed(choiceCurrency,
                startDate,
                finishDate,
                choiceFunction));

    }
}