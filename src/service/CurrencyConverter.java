package service;

//        ARS - Peso argentino
//        BOB - Boliviano boliviano
//        BRL - Real brasileño
//        CLP - Peso chileno
//        COP - Peso colombiano
//        USD - Dólar estadounidense

public class CurrencyConverter {

    public static void test() {
        String API = "https://v6.exchangerate-api.com/v6/18c41e08457e8db7820cd446/latest/COP";
        var response = HttpRequester.get(API);
        System.out.println(response);
    }
}
