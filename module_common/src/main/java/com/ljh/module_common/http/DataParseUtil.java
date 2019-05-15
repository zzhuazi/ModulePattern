package com.ljh.module_common.http;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 服务器返回数据的解析工具，
 * 支持XML、json对象、json数组
 *
 * @author Ljh 2019/5/15 10:41
 */
public class DataParseUtil {

    private DataParseUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 解析Json对象
     *
     * @param string 需要解析的json
     * @param clazz  解析类
     * @param <T>    解析类对象
     * @return 解析类对象
     */
    public static <T> T parseObject(String string, Class<T> clazz) {
        return new Gson().fromJson(string, clazz);
    }

    /**
     * 解析json数组为ArrayList
     *
     * @param json  要解析的json
     * @param clazz 解析类
     * @return arrayList
     */
    public static <T> ArrayList<T> parseToArrayList(String json, Class<T> clazz) {
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);
        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }

    /**
     * 解析json数组为List
     *
     * @param json  要解析的json
     * @param clazz 解析类
     * @return List
     */
    public static <T> List<T> parseToList(String json, Class<T[]> clazz) {
        Gson gson = new Gson();
        T[] array = gson.fromJson(json, clazz);
        return Arrays.asList(array);
    }

    /**
     * 解析Xml格式数据
     *
     * @param json  要解析的json
     * @param clazz 解析类
     */
    public static Object parseXml(String json, Class<?> clazz){
        try{
            if(!TextUtils.isEmpty(json) && clazz!= null) {
//                Serializer serializer = new Persister();
//                InputStreamReader is = new InputStreamReader(new ByteArrayInputStream(json.getBytes("UTF-8")), "utf-8");
//                return serializer.read(clazz, is);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
