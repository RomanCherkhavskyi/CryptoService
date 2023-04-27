package org.example.filereaders;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.example.entity.Currency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXTFileReader implements Readable {
    @SneakyThrows
    @Override
    public List<Currency> readFile(String filePath) {
        List<Currency> currencyList = new ArrayList<>();
        Gson gson = new Gson();
        BufferedReader bf;

        bf = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = bf.readLine()) != null) {
            currencyList.add(gson.fromJson(line, Currency.class));
        }
        return currencyList;
    }

    @SneakyThrows
    @Override
    public List<Currency> extractByUserPeriod(List<Currency> currencies, String startDate, String finishDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date mindate = dateFormat.parse(startDate);
        Date maxdate = dateFormat.parse(finishDate);

        List<Currency> findList = new ArrayList<>();
        for (Currency currency : currencies) {
            Date date;
            date = dateFormat.parse(currency.getTimestamp());
            if ((date.getTime() >= mindate.getTime()) && (date.getTime() <= maxdate.getTime())) {
                findList.add(currency);
            }
        }
        return findList;

    }


}
