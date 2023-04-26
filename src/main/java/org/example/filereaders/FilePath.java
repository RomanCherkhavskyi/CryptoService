package org.example.filereaders;

public class FilePath {

    private static final String BTC = "src\\main\\resources\\prices\\BTC_values.txt";
    private static final String ETH = "src\\main\\resources\\prices\\ETH_values.txt";
    private static final String LTC = "src\\main\\resources\\prices\\LTC_values.csv";
    private static final String DOGE = "src\\main\\resources\\prices\\DOGE_values.csv";
    private static final String XRP = "src\\main\\resources\\prices\\XRP_values.csv";

    public String getBTC() {
        return BTC;
    }

    public String getETH() {
        return ETH;
    }

    public String getLTC() {
        return LTC;
    }

    public String getDOGE() {
        return DOGE;
    }

    public String getXRP() {
        return XRP;
    }
}
