package org.example.entity;

public class Currency {
    private final String timestamp;
    private final String symbol;
    private final double price;

    public Currency(String timestamp, String symbol, double price) {
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.price = price;
    }



    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public String getTimestamp() {
        return timestamp;
    }



    @Override
    public String toString() {
        return "Currency{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
