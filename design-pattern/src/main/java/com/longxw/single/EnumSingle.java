package com.longxw.single;

import java.sql.Connection;
import java.sql.DriverManager;

public enum EnumSingle {
    INSTANCE;

    private Connection connection;

    EnumSingle(){
        try {
            //create single object
            connection = DriverManager.getConnection("");
        }catch (Exception e){

        }
    }

    public Connection getConnection(){
        return connection;
    }
}
