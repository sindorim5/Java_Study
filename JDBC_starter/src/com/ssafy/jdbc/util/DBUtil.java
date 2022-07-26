package com.ssafy.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
    static final String ID = "ssafy";
    static final String PASSWORD = "ssafy";

    //static block 이용하여 driver 로딩
    static {
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * Singleton class, 
     * private 생성자 
     */
    private DBUtil() {}
    
    /** connection 리턴.
     */
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
