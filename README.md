# javaorm
A simple java orm to training reflection and database concepts

## Example
```
        UserTest userTest = new UserTest();
        userTest.setName("thalles");
        DB db = DB.Open(url, Driver.POSTGRES, postgresContainer.getUsername(), postgresContainer.getPassword());
        db.CreateTable(userTest);
        db.Insert(userTest); 
```
