package org.example;

import org.example.database.parser.CreateStatementParser;
import org.example.database.parser.FindStatementParser;
import org.example.database.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

public class FindStatementTest {

    @Test
    public void CreateObjectStatementTest() {
        UserTest user = new UserTest();
        user.setAge("20");
        user.setName("thalles");
        user.setId("1");
        String statement = Parser.parseStatement(new FindStatementParser(), user);
        Assert.assertEquals("SELECT id, name, age FROM UserTest", statement);
    }
}
