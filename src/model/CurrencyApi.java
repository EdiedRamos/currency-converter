package model;


import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record CurrencyApi(
        @SerializedName("base_code")
        String baseCode,
        @SerializedName("conversion_rates")
        Map<String, Double> conversionRates) {}
