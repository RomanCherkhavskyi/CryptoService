package org.example.filereaders;

import org.example.entity.Currency;

import java.util.List;

public interface Readable {

    List<Currency> readFile(String filePath);

    List<Currency> extractByUserPeriod(List<Currency> currencies, String startDate, String finishDate);
}
