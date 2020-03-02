package com.longxw.pattern.single;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 枚举的单例实现方式
 * @author longxw
 * @since 2020/3/2
 */
public class ConnectionSingleManager {

    public static Connection getConnection(){
        return EnumSingle.INSTANCE.getConnection();
    }

    private enum EnumSingle {
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
}
