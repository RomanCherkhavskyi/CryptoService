package org.example.filereaders;

import com.opencsv.CSVReader;
import lombok.SneakyThrows;
import org.example.entity.Currency;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVFileReader implements Readable {
@SneakyThrows
    @Override
    public List<Currency> readFile(String filePath) {
        CSVReader csvReader;
            csvReader = new CSVReader(new FileReader(filePath));
        List<Currency> csvCurrencyList = new ArrayList<>();
            csvReader.skip(1);
        String[] line;
                while ((line = csvReader.readNext()) != null) {
                    csvCurrencyList.add(
                            new Currency(line[0],
                                    line[1],
                                    Double.parseDouble(line[2])));
                }

            csvReader.close();

        return csvCurrencyList;
    }
@SneakyThrows
    @Override
    public List<Currency> extractByUserPeriod(List<Currency> currencies, String startDate, String finishDate) {
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
