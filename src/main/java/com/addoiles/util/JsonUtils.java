package com.addoiles.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

public class JsonUtils {

    private JsonUtils() {
    }

    public static String toJson(Object object) {
        return JSON.toJSONString(object,
                new SerializerFeature[]{WriteMapNullValue,
                        DisableCircularReferenceDetect,
                        WriteNonStringKeyAsString});
    }

    public static String toJsonFormat(Object object) {
        return JSON.toJSONString(object,
                new SerializerFeature[]{WriteMapNullValue, PrettyFormat,
                        DisableCircularReferenceDetect,
                        WriteNonStringKeyAsString});
    }

    public static Object toJsonObject(Object obj) {
        return JSON.toJSON(obj);
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        return JSON.parseObject(jsonString, clazz);
    }

    public static <T> T fromJson(String jsonString) throws Exception {
        return JSON.parseObject(jsonString, new TypeReference<T>() {
        }, new Feature[0]);
    }
}
