package org.example;


import org.example.functions.Calculate;
import org.example.functions.UserDataParser;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int choiceCurrency;
        String currencyName;
        String startDate;
        String finishDate;
        int choiceFunction;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number about currency you need" + "\n" +
                "1:BTC, 2:ETH, 3:DOGE, 4:LTC, 5:XRP");
        choiceCurrency = Integer.parseInt(scanner.nextLine());
        switch (choiceCurrency) {
            case 1:
                currencyName = "BTC";
                System.out.println("You choose " + currencyName + " currency");
                break;
            case 2:
                currencyName = "ETH";
                System.out.println("You choose " + currencyName + " currency");
                break;
            case 3:
                currencyName = "DOGE";
                System.out.println("You choose " + currencyName + " currency");
                break;
            case 4:
                currencyName = "LTC";
                System.out.println("You choose " + currencyName + " currency");
                break;
            case 5:
                currencyName = "XRP";
                System.out.println("You choose " + currencyName + " currency");
                break;
            default:
                System.out.println("You entered non-correct number of currency: " + choiceCurrency);
                return;
        }

        System.out.println("Please enter a start date and time in next format: yyyy-MM-dd'T'HH:mm");
        startDate = scanner.nextLine();
        if (!new UserDataParser().dateParse(startDate)) return;


        System.out.println("Please enter a finish date in next format: yyyy-MM-dd'T'HH:mm");
        finishDate = scanner.nextLine();
        if (!new UserDataParser().dateParse(finishDate)) return;

        System.out.println("Please select what you need calculate:" + "\n" +
                "1:min, 2:max, 3:middle, 4:normal");
        choiceFunction = Integer.parseInt(scanner.nextLine());
        switch (choiceFunction) {
            case 1:
                System.out.println("You choose calculate minimal value");
                break;
            case 2:
                System.out.println("You choose calculate maximal value");
                break;
            case 3:
                System.out.println("You choose calculate middle value");
                break;
            case 4:
                System.out.println("You choose calculate normal value");
                break;
            default:
                System.out.println("You entered non-correct number of function");
                return;
        }

        System.out.println(new Calculate().calculateUserNeed(choiceCurrency,
                startDate,
                finishDate,
                choiceFunction));

    }
}