package com.ssafy.jdbc;

import java.sql.*;

//com.mysql.cj.jdbc.Driver
//jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8

public class JDBC2PreparedStatementTest {
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
	static final String ID = "ssafy";
	static final String PASSWORD = "ssafy";

	public static void main(String[] args) {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "select id, password from user where id = ?";

		try (Connection con = DriverManager.getConnection(URL, ID, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(query);
			) {

			// 첫번째 물음표에 a01 대입
			pstmt.setString(1, "a01");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);

				System.out.println(id + "\t" + pw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
