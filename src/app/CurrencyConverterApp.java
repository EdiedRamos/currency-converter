package app;

import com.google.gson.Gson;
import model.CurrencyApi;
import service.CurrencyConverter;
import service.ExchangeAPI;
import service.HttpRequester;
import ui.ConsoleUI;

public class CurrencyConverterApp {
    public static void main(String[] args) {
//        ConsoleUI.initCLI();
//        CurrencyConverter.test();
        ExchangeAPI eapi  = new ExchangeAPI();
        var data = eapi.getCurrencyData("COP");
        System.out.println(data.conversionRates().get("USD") * 8000000);
    }
}
