package com.ssafy.cafe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static final String URL = "jdbc:mysql://127.0.0.1:3306/ssafy_mobile_cafe?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String ID = "ssafy";
    static final String PASSWORD = "ssafy";

    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, ID, PASSWORD);
    }

    public static void close(AutoCloseable c) {
        if (c != null) {
            try {
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
