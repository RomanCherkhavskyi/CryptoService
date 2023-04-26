package org.example;

import org.example.filereaders.CSVFileReader;
import org.example.filereaders.FilePath;
import org.example.filereaders.TXTFileReader;
import org.example.functions.Calculate;
import org.example.entity.Currency;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Currency> currencies = new TXTFileReader()
                .readFile(new FilePath().getBTC());
        System.out.println(currencies);

        String startDate = "2022-01-01T00:00";
        String finishDate = "2022-01-01T17:00";

        List<Currency> findList = new TXTFileReader().extractByUserPeriod(currencies,startDate,finishDate);
        System.out.println(findList);

        Currency min = new Calculate().min(findList);
        System.out.println("Minimal value is "+min);

        Currency max = new Calculate().max(findList);
        System.out.println("Maximal value is "+max);

        double middle = new Calculate().average(findList);
        System.out.println("Middle value is "+middle);

        double normal = new Calculate().normal(findList);
        System.out.println("Normal is "+normal);

        System.out.println("-------------------------------------------");


        List<Currency> currencies2 = new CSVFileReader()
                .readFile(new FilePath().getLTC());
        System.out.println(currencies2);

        String startDate2 = "2022-01-01T00:00";
        String finishDate2 = "2022-01-05T10:00";

        List<Currency> findList2 = new CSVFileReader().extractByUserPeriod(currencies2,startDate2,finishDate2);
        System.out.println(findList2);

        Currency min2 = new Calculate().min(findList2);
        System.out.println("Minimal value is "+min2);

        Currency max2 = new Calculate().max(findList2);
        System.out.println("Maximal value is "+max2);

        double middle2 = new Calculate().average(findList2);
        System.out.println("Middle value is "+middle2);

        double normal2 = new Calculate().normal(findList2);
        System.out.println("Normal is "+normal2);

    }
}
