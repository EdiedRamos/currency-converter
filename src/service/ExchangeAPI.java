package service;

import domain.Converter;
import model.CurrencyApi;

public class ExchangeAPI {
    private String BASE_API = "https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{CODE}";

    public ExchangeAPI() {
        updateApi("{API_KEY}", System.getenv("API_KEY"));
    }

    private void updateApi(String target, String value) {
        BASE_API = BASE_API.replace(target, value);
    }

    public CurrencyApi getCurrencyData(String baseCode) {
        updateApi("{CODE}", baseCode);
        var response = HttpRequester.get(BASE_API);
        return Converter.deserializeJson(response, CurrencyApi.class);
    }
}
