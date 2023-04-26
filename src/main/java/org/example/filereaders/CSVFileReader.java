package org.example.filereaders;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.entity.Currency;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVFileReader implements Readable {

    @Override
    public List<Currency> readFile(String filePath) {
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Currency> csvCurrencyList = new ArrayList<>();
        try {
            csvReader.skip(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] line;
        while (true) {
            try {
                if ((line = csvReader.readNext()) == null) break;
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException(e);
            }
            csvCurrencyList.add(
                    new Currency(line[0], line[1], Double.parseDouble(line[2])));
        }
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return csvCurrencyList;
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
            long date = Long.parseLong(currency.getTimestamp());
            if ((date >= mindate.getTime()) && (date <= maxdate.getTime())) {
                findList.add(currency);
            }
        }
        return findList;
    }


}
