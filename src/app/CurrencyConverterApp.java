package app;

import com.google.gson.Gson;
import model.CurrencyApi;
import service.CurrencyConverter;
import service.HttpRequester;
import ui.ConsoleUI;

public class CurrencyConverterApp {
    public static void main(String[] args) {
//        ConsoleUI.initCLI();
        CurrencyConverter.test();
    }
}
