package org.example.functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataParser {

    public boolean dateParse(String date) {
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

}
