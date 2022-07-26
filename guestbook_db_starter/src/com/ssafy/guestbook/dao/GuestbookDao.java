package com.ssafy.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.guesbook.dto.GuestbookDto;
import com.ssafy.guestbook.util.DBUtil;

public class GuestbookDao {

	public void writeArticle(GuestbookDto dto) {
		String username = dto.getUsername();
		String subject = dto.getSubject();
		String content = dto.getContent();
		String sql = "insert into guestbook (username, subject, content) values(? ,?, ?)";

		try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, username);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);

			pstmt.executeUpdate();
			System.out.println("Write Complete");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<GuestbookDto> listArticle() {
		ArrayList<GuestbookDto> result = new ArrayList<>();
		String sql = "select * from guestbook";
		try (Connection con = DBUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				String username = rs.getString(2);
				String subject = rs.getString(3);
				String content = rs.getString(4);
				String regtime = rs.getString(5);
				GuestbookDto temp = new GuestbookDto(username, subject, content, regtime);
				result.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
