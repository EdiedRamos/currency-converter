package domain;

import com.google.gson.Gson;

public class Converter {

    public static String serializeToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> T deserializeJson(String jsonString, Class<T> valueType) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, valueType);
    }

}
