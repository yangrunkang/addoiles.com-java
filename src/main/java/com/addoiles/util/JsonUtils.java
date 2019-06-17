package com.addoiles.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

/**
 * 使用Gson 替换alibaba的fastjson
 */
public class JsonUtils {

    private static Gson gson = new Gson();

    private JsonUtils() {
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }


    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        return gson.fromJson(jsonString,clazz);
    }


}
