package org.example.functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataCheck {

    public boolean dateCheck(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date startDate;
        try {
            startDate = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("You enter date in non-correct date format");
            return false;

        }
        System.out.println("Date is: " + startDate);
        return true;
    }

    public boolean currencyCheck(int choiceCurrency) {
        String currencyName;
        switch (choiceCurrency) {
            case 1:
                currencyName = "BTC";
                System.out.println("You choose " + currencyName + " currency");
                return true;

            case 2:
                currencyName = "ETH";
                System.out.println("You choose " + currencyName + " currency");
                return true;

            case 3:
                currencyName = "DOGE";
                System.out.println("You choose " + currencyName + " currency");
                return true;

            case 4:
                currencyName = "LTC";
                System.out.println("You choose " + currencyName + " currency");
                return true;

            case 5:
                currencyName = "XRP";
                System.out.println("You choose " + currencyName + " currency");
                return true;

            default:
                System.out.println("You entered non-correct number of currency: " + choiceCurrency);
                return false;
        }
    }

    public boolean functionCheck(int choiceFunction) {
        switch (choiceFunction) {
            case 1:
                System.out.println("You choose calculate minimal value");
                return true;
            case 2:
                System.out.println("You choose calculate maximal value");
                return true;
            case 3:
                System.out.println("You choose calculate middle value");
                return true;
            case 4:
                System.out.println("You choose calculate normal value");
                return true;
            default:
                System.out.println("You entered non-correct number of function");
                return false;
        }
    }
}
