package org.example.database;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateStatementParser implements StatementParser {
    private String[] keys = {"INSERT", "VALUES"};


    @Override
    public String parse(Object object) {
        Map<String,Object> keyValueFields  = parseObject(object);
        return createStatement(keyValueFields, object.getClass().getSimpleName());
    }

    private String createStatement(Map<String, Object> keyValueFields, String name) {
        StringBuilder statement = new StringBuilder();

        for(String key : keys ) {
            if (key.equals("INSERT")) {
                statement.append(String.format("%s %s %s%s ", key, "INTO", name, getKeysStatement(keyValueFields)));
            }else {
                statement.append(String.format("%s %s", key, getValuesStatement(keyValueFields)));
            }
        }
        return statement.toString();
    }

    private String getValuesStatement(Map<String, Object> keyValueFields) {
        return keyValueFields.entrySet().stream().map(it-> String.format("'%s'",it.getValue())).collect(Collectors.joining(", ","(", ")"));
    }

    private String getKeysStatement(Map<String,Object> keys) {
        return keys.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.joining(", ","(", ")"));
    }

    private Map<String,Object> parseObject(Object object) {
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
}
