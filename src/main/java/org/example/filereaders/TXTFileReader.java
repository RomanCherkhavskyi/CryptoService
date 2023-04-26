package org.example.filereaders;

import com.google.gson.Gson;
import org.example.entity.Currency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXTFileReader implements Readable {
    @Override
    public List<Currency> readFile(String filePath) {
        List<Currency> currencyList = new ArrayList<>();
        Gson gson = new Gson();
        BufferedReader bf;
        try {
            bf = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while (true) {
            try {
                if ((line = bf.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            currencyList.add(gson.fromJson(line, Currency.class));
        }
        return currencyList;
    }

    @Override
    public List<Currency> findAll(List<Currency> currencies, String startDate, String finishDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date mindate;
        try {
            mindate = dateFormat.parse(startDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date maxdate;
        try {
            maxdate = dateFormat.parse(finishDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<Currency> findList = new ArrayList<>();

        for (Currency currency : currencies) {
            Date date;
            try {
                date = dateFormat.parse(currency.getTimestamp());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            if ((date.getTime() >= mindate.getTime()) && (date.getTime() <= maxdate.getTime())) {
                findList.add(currency);
            }
        }
        return findList;

    }


}
