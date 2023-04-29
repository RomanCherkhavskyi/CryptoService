package org.example.functions;

import org.example.entity.Currency;
import org.example.filereaders.CSVFileReader;
import org.example.filereaders.Readable;
import org.example.filereaders.FilePath;
import org.example.filereaders.TXTFileReader;

import java.util.Comparator;
import java.util.List;

public class Calculate {


    public Currency min(List<Currency> currencies) {        
        //I have said many times that returning null is an antipattern. 
        //but returning null from a class that the client is using is doubly antipattern!!! solution is optional
        return currencies.stream()
                .min(Comparator.comparing(Currency::getPrice))
                .orElse(null);
    }

    public Currency max(List<Currency> currencies) {
        //the same as previos
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
        //this is a really good solution. we are reusing logic that is written in another method, rather than duplicating code. do it always!!! :)
        return (max(currencies).getPrice() - min(currencies).getPrice()) / min(currencies).getPrice();
    }

    public String calculateUserNeed(int choiceCurrency, String startDate, String finishDate, int choiceFunction) {
        //switch/case should only be used as a last resort
        //the same issue with cintroller (GRASP)
        String filePath = FilePath.getByIndex(choiceFunction);
        
        //No, no and again no! 
        //we will not instantiate the class twice(TXTFileReader and CSVFileReader) and do useful work in the if/then block. 
        //instead of it we must use polymorphism (even on the client side)
        Readable readable = choiceCurrency == 1 || choiceCurrency == 2 ? new TXTFileReader() : new CSVFileReader();
        List<Currency> currencies = readable.extractByUserPeriod(readable.readFile(filePath), startDate, finishDate);
  
        //what happens if the client does not need to output anything to the console (but we use 'System.out.println("Minimal currency is");') 
        //and why did we decide that returning a number in a string variable is convenient?
        //we shouldn't use 'System.out.println' at all!
        
        //Sorry, but I can't fix it because polymorphism needs to work here. 
        //as a result of violating the principle of single responsibility, our class considers everything in general 
        //and we are forced to use a switch/case to guess which method to call instead of using polymorphism
        String result = "not data";
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
