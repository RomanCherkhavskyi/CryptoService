package org.example.filereaders;

import org.example.entity.Currency;

import java.util.List;

public interface Readable {

    public List<Currency> readFile(String filePath);

    public List<Currency> findAll(List<Currency> currencies, String startDate, String finishDate);


}
