package service;

public class CurrencyConverter {
    public static Double convert(String from, String to, Double quantity) {
        ExchangeAPI exchange = new ExchangeAPI();
        var data = exchange.getCurrencyData(from);
        return quantity * data.conversionRates().get(to);
    }
}
