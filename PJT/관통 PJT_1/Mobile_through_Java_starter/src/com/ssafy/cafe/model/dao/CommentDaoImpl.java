package com.ssafy.cafe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.cafe.model.dto.Comment;
import com.ssafy.cafe.util.DBUtil;

public class CommentDaoImpl implements CommentDao {

    private static CommentDao instance;

    public static CommentDao getInstance() {
        if (instance == null) {
            instance = new CommentDaoImpl();
        }
        return instance;
    }

    private CommentDaoImpl() {
    }

    public int insert(Comment comment) {

        int result = -1;

        String sql = "insert into t_comment (user_Id, product_Id, rating, comment) values (?,?,?,?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, comment.getUserId());
            pstmt.setInt(2, comment.getProductId());
            pstmt.setDouble(3, comment.getRating());
            pstmt.setString(4, comment.getComment());

            result = pstmt.executeUpdate();
            System.out.println(result + "건 입력 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int update(Comment comment) {
        int result = -1;
        String sql = "update t_comment set rating = ?, comment = ? where user_id = ? and product_id = ?";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setDouble(1, comment.getRating());
            pstmt.setString(2, comment.getComment());
            pstmt.setString(3, comment.getUserId());
            pstmt.setInt(4, comment.getProductId());
            // 처리된 건수가 리턴
            result = pstmt.executeUpdate();

            System.out.println(result + "건이 update 되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Integer commentId) {

        int result = -1;

        String sql = "delete from t_comment where id=?";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setInt(1, commentId);
            // 처리된 건수가 리턴
            result = pstmt.executeUpdate();

            System.out.println(result + "건이 delete 되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    public Comment select(Integer commentId) {
        Comment tempComment = new Comment();

        String sql = "select * from t_comment where id=?";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setInt(1, commentId);
            ResultSet rs = pstmt.executeQuery();

            // 처리된 건수가 리턴
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String userId = rs.getString(2);
                Integer productId = rs.getInt(3);
                Double rating = rs.getDouble(4);
                String comment = rs.getString(5);

                tempComment.setId(id);
                tempComment.setUserId(userId);
                tempComment.setProductId(productId);
                tempComment.setRating(rating);
                tempComment.setComment(comment);

                System.out.println("****" + id + "\t" + userId + "\t" + productId + "\t" + rating + "\t" + comment);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tempComment;
    }

    public List<Comment> selectAll() {
        List<Comment> commentList = new ArrayList<Comment>();
        
        String sql = "select * from t_comment";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            ResultSet rs = pstmt.executeQuery();
            // 처리된 건수가 리턴
            while (rs.next()) {
                Comment tempComment = new Comment();
                Integer id = rs.getInt(1);
                String userId = rs.getString(2);
                Integer productId = rs.getInt(3);
                Double rating = rs.getDouble(4);
                String comment = rs.getString(5);

                tempComment.setId(id);
                tempComment.setUserId(userId);
                tempComment.setProductId(productId);
                tempComment.setRating(rating);
                tempComment.setComment(comment);
                
                commentList.add(tempComment);

                System.out.println(id + "\t" + userId + "\t" + productId + "\t" + rating + "\t" + comment);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return commentList;
    }

    @Override
    public List<Comment> selectByProduct(Integer productId) {  
        List<Comment> commentList = new ArrayList<Comment>();

        String sql = "select * from t_comment where product_id=? order by id desc";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            // 처리된 건수가 리턴
            while (rs.next()) {
                Comment tempComment = new Comment();

                Integer id = rs.getInt(1);
                String userId = rs.getString(2);
                Integer tempProductId = rs.getInt(3);
                Double rating = rs.getDouble(4);
                String comment = rs.getString(5);

                tempComment.setId(id);
                tempComment.setUserId(userId);
                tempComment.setProductId(tempProductId);
                tempComment.setRating(rating);
                tempComment.setComment(comment);
                
                commentList.add(tempComment);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(commentList);

        return commentList;
    }
}
