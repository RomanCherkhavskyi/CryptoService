package org.example.functions;

import org.example.entity.Currency;
import org.example.filereaders.CSVFileReader;
import org.example.filereaders.FilePath;
import org.example.filereaders.TXTFileReader;

import java.util.Comparator;
import java.util.List;

public class Calculate {


    public Currency min(List<Currency> currencies) {

        return currencies.stream()
                .min(Comparator.comparing(Currency::getPrice))
                .orElse(null);
    }

    public Currency max(List<Currency> currencies) {

        return currencies.stream()
                .max(Comparator.comparing(Currency::getPrice))
                .orElse(null);
    }


    public double average(List<Currency> currencies) {

        return currencies.stream()
                .mapToDouble(Currency::getPrice)
                .average()
                .orElse(0d);
    }

    public double normal(List<Currency> currencies) {
        return (max(currencies).getPrice() - min(currencies).getPrice()) / min(currencies).getPrice();
    }

    public String calculateUserNeed(int choiceCurrency, String startDate, String finishDate, int choiceFunction) {
        String filePath = "";
        String result = "not data";
        List<Currency> currencies;
        switch (choiceCurrency) {
            case 1:
                filePath = new FilePath().getBTC();
                break;
            case 2:
                filePath = new FilePath().getETH();
                break;
            case 3:
                filePath = new FilePath().getDOGE();
                break;
            case 4:
                filePath = new FilePath().getLTC();
                break;
            case 5:
                filePath = new FilePath().getXRP();
                break;
        }
        if (choiceCurrency == 1 || choiceCurrency == 2) {
            currencies = new TXTFileReader().extractByUserPeriod(new TXTFileReader().readFile(filePath), startDate, finishDate);
        } else {
            currencies = new CSVFileReader().extractByUserPeriod(new CSVFileReader().readFile(filePath), startDate, finishDate);
        }

        switch (choiceFunction) {
            case 1:
                result = String.valueOf(min(currencies));
                System.out.println("Minimal currency is");
                break;
            case 2:
                result = String.valueOf(max(currencies));
                System.out.println("Maximal currency is");
                break;
            case 3:
                result = String.valueOf(average(currencies));
                System.out.println("Middle currency value is");
                break;
            case 4:
                result = String.valueOf(normal(currencies));
                System.out.println("Normal currency value is");
                break;
        }
        return result;

    }


}
