package org.example.database;

import java.lang.invoke.SwitchPoint;

public enum Driver {
    POSTGRES("Postgres");

    Driver(String postgres) {
    }

    public String getDriverName() {
        switch (this) {
            case POSTGRES:
                return "org.postgresql.Driver";
            default:
                throw new RuntimeException("Driver not supported");
        }
    }
}
