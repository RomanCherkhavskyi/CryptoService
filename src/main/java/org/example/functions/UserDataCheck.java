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
        if (choiceCurrency <1 || choiceCurrency >5) {
            System.out.println("You entered non-correct number of currency");
            return false;
        }
        return true;
    }

    public boolean functionCheck(int choiceFunction) {

        if (choiceFunction <1 || choiceFunction >4){
            System.out.println("You entered non-correct number of function");
            return false;
        }
        return true;
    }
}
