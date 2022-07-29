package com.ssafy.cafe.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.cafe.model.dto.Product;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.util.DBUtil;
import com.ssafy.cafe.util.DuplicateUserException;

public class UserDaoImpl implements UserDao {
    
    private static UserDao instance;
    
    static final String URL = "jdbc:mysql://127.0.0.1:3306/ssafy_mobile_cafe?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
    static final String ID = "ssafy";
    static final String PASSWORD = "ssafy";
    
    public static UserDao getInstance() {
        if(instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }
    
    
    /**
     * 사용자 정보를 추가한다.
     * @param user
     * @return
     */
    public int insert(User user) throws DuplicateUserException {
        int result = -1;
        
        String sql = "insert into t_user (id, name, pass, stamps) values (?, ?, ?, ?)";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPass());
            pstmt.setInt(4, user.getStamps());
            
            result = pstmt.executeUpdate();
            
            System.out.println(result + "건이 입력되었습니다.");
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DuplicateUserException("중복");
        }
        
        return result;
    }

    /**
     * 사용자의 Stamp 정보를 수정한다.
     * @param user
     * @return
     */
    public int updateStamp(User user) {
        int result = -1;
        
        
        String sql = "Update t_user set stamps where id = ?";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            
            pstmt.setString(1, user.getId());
           
            result = pstmt.executeUpdate();
            
            System.out.println(result + "건이 수정되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return result;
    }
    
    /**
     * 사용자 정보를 조회한다.
     * @param userId
     * @return
     */

    public User select(String userId) {
        User user = new User();

        String sql = "select * from t_user where id = ?";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                user.setId(rs.getString(1));
                user.setName(rs.getString(2));
                user.setPass(rs.getString(3));
                user.setStamps(rs.getInt(4));
                System.out.println(user);
                return user;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
        
    }

    /**
     * 사용자 정보를 삭제한다.
     * @param userId
     * @return
     */
    public int delete(String userId) { int result = -1;

    String sql = "Delete from t_user where id = ?";
    try(Connection con = DBUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);) {
        
        pstmt.setString(1, userId);
        
        result = pstmt.executeUpdate();
        
        System.out.println(result + "건이 삭제되었습니다.");
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    
    return result;
    }
    
    public List<User> selectAll() {
        List<User> userlist = new ArrayList<>();
        User user = new User();
        
        String sql = "select * from t_user";
                ;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();) {
            
            
            while(rs.next()) {
                user.setId(rs.getString(1));
                user.setName(rs.getString(2));
                user.setPass(rs.getString(3));
                user.setStamps(rs.getInt(4));
                                
                userlist.add(user);
                
                return userlist;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
    public int update(User user) {
        return 0;
    }
}
