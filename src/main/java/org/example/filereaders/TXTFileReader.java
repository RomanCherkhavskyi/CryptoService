package org.example.filereaders;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.example.entity.Currency;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class TXTFileReader implements Readable {
    
    private final static Gson MAPPER = new Gson();
    
    
    //the same iisue with creator(GRASP) -> BufferedReader bf;
    //very complex implementation (better to use stream api)
    //an unclosed I/O stream is a problem
    @SneakyThrows
    @Override
    public List<Currency> readFile(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
        return reader.lines()
                .map(line->MAPPER.fromJson(line, Currency.class))
                .collect(Collectors.toList());
        }        
    }
    
    /*
    duplicated method with CSVFileReader class!!!
    we must move it to superclass
    */

}
