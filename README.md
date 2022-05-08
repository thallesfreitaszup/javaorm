# javaorm
A simple java orm to training reflection and database concepts

## Example
```
         UserTest userTest = new UserTest();
        userTest.setId("1");
        userTest.setName("thalles");
        userTest.setAge("20");
        PostgreSQLContainer postgresContainer = new PostgreSQLContainer();
        postgresContainer.start();
        String url = postgresContainer.getJdbcUrl();
        DB db = DB.Open(url, Driver.POSTGRES, postgresContainer.getUsername(), postgresContainer.getPassword());
        db.CreateTable(userTest);
        db.Insert(userTest); UserTest userTest = new UserTest();
        userTest.setId("1");
        userTest.setName("thalles");
        userTest.setAge("20");
        PostgreSQLContainer postgresContainer = new PostgreSQLContainer();
        postgresContainer.start();
        String url = postgresContainer.getJdbcUrl();
        DB db = DB.Open(url, Driver.POSTGRES, postgresContainer.getUsername(), postgresContainer.getPassword());
        db.CreateTable(userTest);
        db.Insert(userTest); UserTest userTest = new UserTest();
        userTest.setId("1");
        userTest.setName("thalles");
        userTest.setAge("20");
        PostgreSQLContainer postgresContainer = new PostgreSQLContainer();
        postgresContainer.start();
        String url = postgresContainer.getJdbcUrl();
        DB db = DB.Open(url, Driver.POSTGRES, postgresContainer.getUsername(), postgresContainer.getPassword());
        db.CreateTable(userTest);
        db.Insert(userTest);UserTest userTest = new UserTest();
        userTest.setId("1");
        userTest.setName("thalles");
        userTest.setAge("20");
        PostgreSQLContainer postgresContainer = new PostgreSQLContainer();
        postgresContainer.start();
        String url = postgresContainer.getJdbcUrl();
        DB db = DB.Open(url, Driver.POSTGRES, postgresContainer.getUsername(), postgresContainer.getPassword());
        db.CreateTable(userTest);
        db.Insert(userTest);
```
