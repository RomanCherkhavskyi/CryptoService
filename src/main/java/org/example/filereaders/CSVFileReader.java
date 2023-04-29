package org.example.filereaders;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import org.example.entity.Currency;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileReader implements Readable {

    /*
    1)the same iisue with creator(GRASP)
    2)why we parse it manualy? why don't we use a builder if we have one?
    3)I don't think relying on the column number is a good idea. columns can be swapped. better to base on the headline.
    4)what's the point of using the opencsv in this way? the only thing she does is skip the first row.
    this can be done without a library and there will be no more code. will be better to use bean based solution
    */
    @SneakyThrows
    @Override
    public List<Currency> readFile(String filePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return new CsvToBeanBuilder<>(reader).withType(Currency.class).build().stream()
                    .map(v->(Currency)v).collect(Collectors.toList());
        }
    }
    
    /*
    duplicated method with TXTFileReader class!!!
    we must move it to superclass
    */
}
