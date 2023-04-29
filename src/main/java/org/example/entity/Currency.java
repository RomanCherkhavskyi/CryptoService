package org.example.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
just a note. if the class is not associated with the database, then it is not customary to refer to it as an entity (I'm talking about package naming)
 */
@Data
@AllArgsConstructor
@Builder
public class Currency {

    //string for timestamp? but why??
    @CsvBindByName(column = "timestamp")
    private String timestamp;

    @CsvBindByName(column = "symbol")
    private String symbol;

    @CsvBindByName(column = "price")
    private Double price;

}
