package org.example.database.reflection;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReflectionUtils {

    public static Map<String,Object> getKeyValuesMap(Object object) {
        try {
            Class objectClass = Class.forName(object.getClass().getName());
            Field[] fields = objectClass.getDeclaredFields();
            Map<String, Object> keyValueFields = new LinkedHashMap<>();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value  = field.get(object);
                keyValueFields.put(field.getName(),value);
            }
            return keyValueFields;
        }catch (Exception e ) {
            throw new RuntimeException("Failed to parse object: "+ e.getMessage());
        }
    }

    public static Map<String,Object> getKeyTypeMap(Object object) {
        try {
            Class objectClass = Class.forName(object.getClass().getName());
            Field[] fields = objectClass.getDeclaredFields();
            Map<String, Object> keyValueFields = new LinkedHashMap<>();
            for (Field field : fields) {
                var type = field.getType().getSimpleName();
                keyValueFields.put(field.getName(), getSqlType(type));
            }
            return keyValueFields;
        }catch (Exception e ) {
            throw new RuntimeException("Failed to parse object: "+ e.getMessage());
        }
    }

    private static String getSqlType(String value) {
        switch (value) {
            case "String":
                return "varchar(255)";
            case "Integer":
            case "int":
                return "int";
            case "float":
                return "real";
            case "double":
                return "float8";
            default:
                return value;
        }
    }
}
