package org.example;

import org.example.database.CreateStatementParser;
import org.example.database.Parser;
import org.junit.Assert;
import org.junit.Test;

public class CreateStatementTest {

    @Test
    public void CreateObjectStatementTest() {
        UserTest user = new UserTest();
        user.setAge("20");
        user.setName("thalles");
        user.setId("1");
        String statement = Parser.parseStatement(new CreateStatementParser(), user);
        Assert.assertEquals("INSERT INTO UserTest(id, name, age) VALUES(1, thalles, 20)", statement);
    }
}
