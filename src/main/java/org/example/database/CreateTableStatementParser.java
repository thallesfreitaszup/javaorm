package org.example.database;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateTableStatementParser implements StatementParser {
    private String[] keys = {"CREATE", "TABLE"};
    private String SpaceDelimiter = " ";


    @Override
    public String parse(Object object) {
        Map<String,Object> keyTypeFields  = parseObject(object);
        return createStatement(keyTypeFields, object.getClass().getSimpleName());
    }

    private String createStatement(Map<String, Object> keyValueFields, String name) {
        StringBuilder statement = new StringBuilder();

        for(String key : keys ) {
            statement.append(key);
            statement.append(SpaceDelimiter);
            if (key.equals("TABLE")) {
                statement.append(name);
                statement.append(SpaceDelimiter);
                statement.append(getKeyTypeTableStatement(keyValueFields));
            }
        }
        return statement.toString();
    }

    private String getKeyTypeTableStatement(Map<String, Object> keyValueFields) {
        return keyValueFields.entrySet().stream().map(it -> String.format("%s%s%s",it.getKey(),SpaceDelimiter, it.getValue())).collect(Collectors.joining(",\n","(\n","\n)"));
    }


    private Map<String,Object> parseObject(Object object) {
        try {
            Class objectClass = Class.forName(object.getClass().getName());
            Field[] fields = objectClass.getDeclaredFields();
            Map<String, Object> keyValueFields = new LinkedHashMap<>();
            for (Field field : fields) {
                field.setAccessible(true);
                String value  = field.getType().getSimpleName();
                String type  = getSqlType(value);
                keyValueFields.put(field.getName(), type);
            }
            return keyValueFields;
        }catch (Exception e ) {
            throw new RuntimeException("Failed to parse object: "+ e.getMessage());
        }
    }

    private String getSqlType(String value) {
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
