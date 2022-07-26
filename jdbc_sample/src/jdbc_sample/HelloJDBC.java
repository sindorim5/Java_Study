package jdbc_sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.SQLException;
//import com.mysql.cj.jdbc.Driver;

public class HelloJDBC {
	public static void main(String[] args) {

//		try {	// 실행할 때 driver 로딩해도 됨	???
//			Driver d = new Driver();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String url = "jdbc:mysql://127.0.0.1:3306/world?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
		String user = "ssafy";
		String password = "ssafy";

		try { // String 문자열로 compile 통과 시켜줌
			// Class.forName("Driver className");
			Class.forName("com.mysql.cj.jdbc.Driver"); // runtime시 클래스 존재 체크, registerDriver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "select id, name, countrycode from city where name like 'Se%'";

		// connection
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			// query 문장을 실행한다
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				// rs.getString(2); "name"과 같은 표현
				String name = rs.getString("name");
				String code = rs.getString("countrycode");
				System.out.println("id: " + id + "\tname: " + name + "\tcode: " + code);
			}
			// 연결 끊기
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
