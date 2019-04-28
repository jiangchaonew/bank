package com.airwallex.test.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CHAOJ
 */

public class JsonUtils {
    /**
     * JSON格式化工具 不忽略值为null的字段
     */
    private static final Gson GSON = new GsonBuilder().serializeNulls()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * fromJson
     *
     * @return
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    /**
     * fromJson
     *
     * @return
     */
    public static <T> T fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }

    /**
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    /**
     * @param object
     * @param type
     * @return
     */
    public static String toJson(Object object, Type type) {
        return GSON.toJson(object, type);
    }

    public static JsonObject parse(String message) {
        return (JsonObject) new JsonParser().parse(message);
    }

    public static BigDecimal getAsBigDecimal(JsonObject jo, String memberName) {
        JsonElement je = jo.get(memberName);
        if (je == null) {
            return null;
        }
        return je.getAsBigDecimal();
    }

    public static String getAsString(JsonObject jo, String memberName) {
        JsonElement je = jo.get(memberName);
        if (je == null) {
            return null;
        }
        return je.getAsString();
    }

    public static int getAsInt(JsonObject jo, String memberName) {
        JsonElement je = jo.get(memberName);
        if (je == null) {
            return 0;
        }
        return je.getAsInt();
    }

    public static String buildJsonString(Object... objects) {
        JsonObject jsonObject = new JsonObject();
        if (objects.length % 2 != 0) {
            throw new RuntimeException("the parameter should be paired.");
        }
        for (int i = 0; i < objects.length; i += 2) {
            String key = objects[i].toString();
            Object value = objects[i + 1];
            if (value == null) {
                jsonObject.addProperty(key, "");
            } else if (value instanceof Number) {
                jsonObject.addProperty(key, (Number) value);
            } else if (value instanceof Boolean) {
                jsonObject.addProperty(key, (Boolean) value);
            } else if (value instanceof Date) {
                jsonObject.addProperty(key, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) value));
            } else {
                jsonObject.addProperty(key, value.toString());
            }
        }
        return jsonObject.toString();
    }
}
