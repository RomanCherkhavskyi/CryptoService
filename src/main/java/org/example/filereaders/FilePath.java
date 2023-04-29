package org.example.filereaders;

import java.util.Arrays;
import java.util.List;

public class FilePath {
    
    //hardcoded values???
    //what happens if we add another source file (with new crypto)? do we need to change the code???
    //non static getter used for static variables... how it possible?? its final static variables(constants). you can use it without getters
    //if we are already using hardcode, can we at least use a list or an array, so as not to use a switch / case later?
    //p.s. The implementation I've given is also bad. I will tell you how to do it right on the lecture

    private final static List<String> PATHS = Arrays.asList(
                "src\\main\\resources\\prices\\BTC_values.txt",
                "src\\main\\resources\\prices\\ETH_values.txt",
                "src\\main\\resources\\prices\\LTC_values.csv",
                "src\\main\\resources\\prices\\DOGE_values.csv",
                "src\\main\\resources\\prices\\XRP_values.csv"
        );

    public static String getByIndex(int index) {
        try {
            return PATHS.get(index - 1);
        } catch (Exception e) {
            throw new RuntimeException("Not supported yet!");
        }
    }

}
