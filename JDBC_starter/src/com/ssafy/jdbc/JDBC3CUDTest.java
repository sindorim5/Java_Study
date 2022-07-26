package com.ssafy.jdbc;

import java.sql.*;

/**
 * 
 * DROP SCHEMA IF EXISTS `mydb` ;
 * 
 * -- ----------------------------------------------------- -- Schema mydb --
 * ----------------------------------------------------- CREATE SCHEMA IF NOT
 * EXISTS `mydb` DEFAULT CHARACTER SET utf8 ; USE `mydb` ;
 * 
 * -- ----------------------------------------------------- -- Table
 * `mydb`.`user` -- ----------------------------------------------------- DROP
 * TABLE IF EXISTS `mydb`.`user` ;
 * 
 * CREATE TABLE IF NOT EXISTS `mydb`.`user` ( `id` VARCHAR(45) NOT NULL,
 * `password` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;
 * 
 * insert into user (id, password) values ('a01', 'pass01'), ('a02', 'pass02');
 * commit;
 * 
 */

//com.mysql.cj.jdbc.Driver
//jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8

public class JDBC3CUDTest {
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
	static final String ID = "ssafy";
	static final String PASSWORD = "ssafy";

	public static void main(String[] args) {
		JDBC3CUDTest test = new JDBC3CUDTest();

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		test.selectAllUser();
//		System.out.println("========================");

//		test.insertUser("a03", "pass03");
//		System.out.println("========================");

//		test.selectUser("a03");
//		System.out.println("========================");
//
//		test.updateUser("a03", "password03");
//		test.selectUser("a03");
//		System.out.println("========================");
//
//		test.deleteUser("a03");
//		test.selectAllUser();
//		System.out.println("========================");

	}

	private Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

	private void selectAllUser() {
		Connection con = getConnection();

		// 구현
		String sql = "select id, password from user";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);

				System.out.println(id + "\t" + pw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int insertUser(String id, String password) {
		Connection con = getConnection();
		int result = -1;

		// 구현
		String sql = "insert into user (id, password) values (?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, id);
			pstmt.setString(2, password);
			// 처리된 건수가 리턴
			result = pstmt.executeUpdate();

			System.out.println(i + "건이 입력되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	private void selectUser(String id) {

		// 구현
		String sql = "select * from user where id = ?";
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			pstmt.setString(1, id);

			while (rs.next()) {
				String get_id = rs.getString(1);
				String get_pw = rs.getString(2);

				System.out.println(get_id + "\t" + get_pw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int updateUser(String id, String password) {

		int result = -1;

		// 구현
		String sql = "update user set password=? where id=?";
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, password);
			pstmt.setString(2, id);
			// 처리된 건수가 리턴
			result = pstmt.executeUpdate();

			System.out.println(result + "건이 update되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	private int deleteUser(String id) {

		int result = -1;

		// 구현
		String sql = "delete from user where id=?";
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, id);
			// 처리된 건수가 리턴
			result = pstmt.executeUpdate();

			System.out.println(result + "건이 delete 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
