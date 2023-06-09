package org.example.functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserDataCheck {

    public boolean dateCheck(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("You enter date in non-correct date format");
            return false;
        }
        return true;
    }

    public boolean currencyCheck(int selectCurrency) {
        if (selectCurrency <1 || selectCurrency >5) {
            System.out.println("You entered non-correct number of currency");
            return false;
        }
        return true;
    }

    public boolean functionCheck(int selectFunction) {
        if (selectFunction <1 || selectFunction >4){
            System.out.println("You entered non-correct number of function");
            return false;
        }
        return true;
    }
}
