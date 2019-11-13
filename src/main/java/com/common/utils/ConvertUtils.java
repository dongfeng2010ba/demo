package com.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.dong.demo.vo.EmployeeProcessV;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class ConvertUtils {

    /**
     * 从List<A> copy到List<B>
     * @param list List<A>
     * @param clazz B
     * @return List<B>
     */
    public static <T> List<T> copy(List<?> list, Class<T> clazz){
        String oldOb = JSON.toJSONString(list);
        return JSON.parseArray(oldOb, clazz);
    }

    public static String removeDash(String str){
        if(str == null){
            return null;
        }
        String newStr = str.replaceAll("-","");
        return newStr;
    }




    public static <T> Map<String, T> fromJsonToMap(String jsonStr, Class<T> clazz) {
        Gson gson = new Gson();
        Map<String, T> map = gson.fromJson(jsonStr, Map.class);
        return map;
    }

    public static <T> T jsonToObjByType(String str, TypeReference type) {
        return (T) JSON.parseObject(str, type);
    }

    /**
     * 从对象A copy到 对象B
     * @param ob A
     * @param clazz B.class
     * @return B
     */
    public static <T> T copy(Object ob,Class<T> clazz){
        String oldOb = JSON.toJSONString(ob);
        return JSON.parseObject(oldOb, clazz);
    }

    public static <T> T fromJsonToObject(String jsonStr,Class<T> clazz){
        return  JSON.parseObject(jsonStr, clazz);
    }

    public static  <T> List<T> jsonToList(String data, Class<T> clazz) {
        return JSONArray.parseArray(data, clazz);
    }

    public static int nullToZero(Integer num) {
        return num == null ? 0 : num;
    }


    public static String getEmployeeIds(List<EmployeeProcessV> assignees) {
        String employeeIds = "";
        for(EmployeeProcessV assignee : assignees){
            employeeIds = assignee.getEmployeeId() + ",";//73bde7fc26dd4946b9c4220499aaed4a 张建      JT101   办公室主任(任务处理人的id逗号分隔) 数据库维护获取
        }
        return employeeIds.substring(0,employeeIds.length()-1);
    }

}
