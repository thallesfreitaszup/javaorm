package org.example;

import org.example.database.CreateStatementParser;
import org.example.database.CreateTableStatementParser;
import org.example.database.Parser;
import org.junit.Assert;
import org.junit.Test;

public class CreateTableStatementTest {

    @Test
    public void CreateObjectStatementTest() {
        UserTest user = new UserTest();
        user.setAge("20");
        user.setName("thalles");
        user.setId("1");
        String statement = Parser.parseStatement(new CreateTableStatementParser(), user);
        Assert.assertEquals("CREATE TABLE UserTest (\n" +
                "id varchar(255),\n" +
                "name varchar(255),\n" +
                "age varchar(255)\n" +
                ")", statement);
    }
}
