package com.ssafy.cafe.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.ssafy.cafe.model.dto.Product;
import com.ssafy.cafe.util.DBUtil;

public class ProductDaoImpl implements ProductDao{
    
    private static ProductDao instance;
    
    static final String URL = "jdbc:mysql://127.0.0.1:3306/ssafy_mobile_cafe?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
    static final String ID = "ssafy";
    static final String PASSWORD = "ssafy";
    
    public static ProductDao getInstance() {
        if(instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }
    
    private ProductDaoImpl() {
    }
    
    public int insert(Product product) {
      int result = -1;
      
      String sql = "insert into t_product (id, name, type, price, img) values(?, ?, ?, ?, ?)";
      try(Connection con = DBUtil.getConnection();
          PreparedStatement pstmt = con.prepareStatement(sql);) {
          
          pstmt.setInt(1, product.getId());
          pstmt.setString(2, product.getName());
          pstmt.setString(3, product.getType());
          pstmt.setInt(4, product.getPrice());
          pstmt.setString(5, product.getImg());
          
          result = pstmt.executeUpdate();
          
          System.out.println(result + "건이 입력되었습니다.");
          
      } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      
      return result;
        
    }

    public int update(Product product) {
        
        int result = -1;
        
        
        String sql = "Update t_product set name = ?, type = ?, price = ?, img = ? where id = ?";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getType());
            pstmt.setInt(3, product.getPrice());
            pstmt.setString(4, product.getImg());
            pstmt.setInt(5, product.getId());
            
            result = pstmt.executeUpdate();
            
            System.out.println(result + "건이 수정되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return result;
    }

    public int delete(Integer productId) {
        int result = -1;

        String sql = "Delete from t_product where id = ?";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {
            
            pstmt.setInt(1, productId);
            
            result = pstmt.executeUpdate();
            
            System.out.println(result + "건이 삭제되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return result;
        
    }

    public Product select(Integer productId) {
        Product product = new Product();

        String sql = "select * from t_product where id = ?";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ) {
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(1, productId);
            
            while(rs.next()) {
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setPrice(rs.getInt(4));
                product.setImg(rs.getString(5));
                
                return product;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        
    }

    public List<Product> selectAll(){
        
        ArrayList<Product> productlist = new ArrayList<>();
        
        
        String sql = "select * from t_product";
           
        try(Connection con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setType(rs.getString(3));
                product.setPrice(rs.getInt(4));
                product.setImg(rs.getString(5));
                
                productlist.add(product);
                
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productlist;
    }
}
