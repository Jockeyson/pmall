package com.sj.pmallcommon.redis.jedis;

import com.alibaba.fastjson.JSON;

import java.nio.charset.Charset;

/**
 * json  Serializer util
 */
public class JsonUtil {
    public static final String UTF_8 = "UTF-8";
    /**
     * @param obj
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] objToByteArray(T obj) {
        return JSON.toJSONString(obj).getBytes(Charset.forName(UTF_8));
    }

    /**
     *
     * @param value
     * @param <T>
     * @return
     */
    public static <T> String objToString(T value) {
        if(value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class) {
            return ""+value;
        }else if(clazz == String.class) {
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class) {
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T byteArrayToObj(byte[] data, Class<T> clazz) {
        return JSON.parseObject(data, clazz);
    }

    /**
     *
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T stringToObj(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class) {
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class) {
            return  (T)Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

}

