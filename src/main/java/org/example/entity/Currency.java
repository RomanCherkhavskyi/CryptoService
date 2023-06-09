package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Currency {
    private  String timestamp;
    private  String symbol;
    private  double price;

}
