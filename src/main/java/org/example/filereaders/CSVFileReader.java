package org.example.filereaders;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.entity.Currency;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVFileReader {


    public List<Currency> readFile(String filePath) throws CsvValidationException, IOException {
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        List<Currency> csvCurrencyList = new ArrayList<>();
        csvReader.skip(1);
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            csvCurrencyList.add(
                    new Currency(line[0], line[1], Double.parseDouble(line[2])));
        }
        csvReader.close();
        return csvCurrencyList;
    }

    public List<Currency> findAll(List<Currency> currencies, String startDate, String finishDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date mindate = dateFormat.parse(startDate);
        Date maxdate = dateFormat.parse(finishDate);
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
