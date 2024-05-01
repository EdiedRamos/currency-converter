package service;

//        ARS - Peso argentino
//        BOB - Boliviano boliviano
//        BRL - Real brasileño
//        CLP - Peso chileno
//        COP - Peso colombiano
//        USD - Dólar estadounidense

public class CurrencyConverter {

    public static void test() {
        String API = "https://v6.exchangerate-api.com/v6/{API_KEY}/latest/COP".replace("{API_KEY}", System.getenv("API_KEY"));
        var response = HttpRequester.get(API);
        System.out.println(response);
    }
}
