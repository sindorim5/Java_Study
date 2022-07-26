package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.jdbc.util.DBUtil;

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

public class JDBC4CRUDTestUsingDBUtil {

	public static void main(String[] args) {
		JDBC4CRUDTestUsingDBUtil test = new JDBC4CRUDTestUsingDBUtil();

		test.selectAllUser();
		System.out.println("========================");

		test.insertUser("a03", "pass03");
		System.out.println("========================");

		test.selectUser("a03");
		System.out.println("========================");

		test.updateUser("a03", "password03");
		test.selectUser("a03");
		System.out.println("========================");

		test.deleteUser("a03");
		test.selectAllUser();
		System.out.println("========================");

	}

	private int insertUser(String id, String password) {

		int result = -1;
		String sql = "insert into user (id, password)values(? ,?)";
		Connection con = null;

		try {
			con = DBUtil.getConnection();
			// con.setAutoCommit(false); // tx(transaction) 관리를 코드로 실행
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// try-with-resources
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			result = pstmt.executeUpdate();
//            int i = 100;
//            
//            if (i > 200) {
//            	con.commit();
//            } else {
//            	con.rollback();	// 조건에 따라 동작
//            }
			System.out.println("insert success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// con.setAutoCommit(true); // 실행이 끝나면 다시 돌려 놓자
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private int updateUser(String id, String password) {

		int result = -1;
		String sql = "update user set password = ? where id = ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, password);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();
			System.out.println("update success");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	private int deleteUser(String id) {
		int result = -1;
		String sql = "delete from user where id = ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();
			System.out.println("delete success");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private void selectAllUser() {
		String sql = "select id, password from user";

		try (Connection con = DBUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				String deptId = rs.getString("id");
				String deptName = rs.getString(2);

				System.out.println("id : " + deptId + ", password : " + deptName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void selectUser(String id) {

		String sql = "select id, password from user where id = ?";

		try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, id);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					String deptId = rs.getString("id");
					String deptName = rs.getString(2);

					System.out.println("selectUser: id : " + deptId + ", password : " + deptName);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
