package org.example.filereaders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
//Date is in fact deprecated class. Wil be batter to use LocalDate (java.time*)
import java.util.Date;
import org.example.entity.Currency;
import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;

@FunctionalInterface
public interface Readable {

    //will be batter to use Path or InputStream instaed of String
    List<Currency> readFile(String filePath);
    
    /*
    Are you sure that this method is the responsibility of the parser?
    What about the Single Responsibility Principle?
    After all, the parer already has a responsibility - it is to read data from a file
    In this case the datas filtering is the second responsibility?
    it doesn't cost us anything to accept a collection instead of a list. so why do we limit the possibilities of the method to a list?
    */
    @SneakyThrows
    default List<Currency> extractByUserPeriod(Collection<Currency> currencies, String startDate, String finishDate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date mindate = formatter.parse(startDate);
        Date maxdate = formatter.parse(finishDate);
        return currencies.stream()
                .filter(currency -> {
                    //these are the consequences of using string for date and time
                    long date = Long.parseLong(currency.getTimestamp());
                    return (date >= mindate.getTime()) && (date <= maxdate.getTime());
                })
                .collect(Collectors.toList());
    }
}
