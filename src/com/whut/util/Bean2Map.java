package com.whut.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Bean2Map {

    public static Map<String, Object> bean2map(Object obj) {
        if(obj == null){    
            return null;    
        }   
        Map<String, Object> map = new HashMap<String, Object>();    
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();    
            for (Field field : declaredFields) {    
                field.setAccessible(true);  
                map.put(field.getName(), field.get(obj));  
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;  

    }
}