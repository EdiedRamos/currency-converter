package ui;

import service.CurrencyConverter;

import java.text.DecimalFormat;
import java.util.*;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    private void insertDecoration() {
        System.out.println("=".repeat(50));
    }

    private String currencyFromOption(String option) {
        Map<String, String> relation = new HashMap<>(){{
            put("1", "ARS");
            put("2", "BOB");
            put("3", "BRL");
            put("4", "CLP");
            put("5", "COP");
            put("6", "USD");
        }};
        return relation.get(option);
    }

    private boolean isWrongOption(String option) {
        try {
            int intOption = Integer.parseInt(option);
            return intOption < 1 || intOption > 6;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private String getCurrency() {
        String option = "";
        while (isWrongOption(option)) {
            System.out.println("1. ARS - Peso argentino");
            System.out.println("2. BOB - Boliviano boliviano");
            System.out.println("3. BRL - Real brasileño");
            System.out.println("4. CLP - Peso chileno");
            System.out.println("5. COP - Peso colombiano");
            System.out.println("6. USD - Dólar estadounidense");
            option = scanner.nextLine();
        }
        return option;
    }

    private void welcomeText() {
        insertDecoration();
        System.out.println("💱BIENVENIDO AL SISTEMA DE CONVERSIÓN DE MONEDA💱");
        insertDecoration();
    }

    private String selectedOption() {
        insertDecoration();
        System.out.println("1. Realizar conversión");
        System.out.println("2. Salir");
        insertDecoration();
        return scanner.nextLine();
    }

    private double getQuantity() {
        System.out.println("INGRESE LA CANTIDAD QUE DESEA CONVERTIR");
        double quantity = scanner.nextDouble();
        scanner.nextLine();
        return quantity;
    }

    private void showResult(String currencyFrom, String currencyTo, double quantity) {
        var result = CurrencyConverter.convert(currencyFrom, currencyTo, quantity);
        DecimalFormat format = new DecimalFormat("#,##0.00");
        System.out.println(format.format(quantity) + " " + currencyFrom + " EQUIVALE A " + format.format(result) + " " + currencyTo);
    }

    private void convertOptions() {
        System.out.println("🌐SELECCIONA LA DIVISA🌐");
        String currencyOption = currencyFromOption(getCurrency());
        double quantity = getQuantity();
        System.out.println("🔃SELECCIONA LA DIVASA DE CONVERSIÓN🔃");
        String conversionOption = currencyFromOption(getCurrency());
        showResult(currencyOption, conversionOption, quantity);
    }

    private void uiLoop() {
        String selected = "";
        while (!selected.equals("2")) {
            selected = selectedOption();
            if (selected.equals("1")) {
                convertOptions();
            }
        }
    }

    public void initCLI() {
        welcomeText();
        uiLoop();
    }

}
