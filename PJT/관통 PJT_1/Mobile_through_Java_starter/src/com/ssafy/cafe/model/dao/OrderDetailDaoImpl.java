package com.ssafy.cafe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.OrderDetail;
import com.ssafy.cafe.util.DBUtil;

public class OrderDetailDaoImpl implements OrderDetailDao {

    private static OrderDetailDao instance;

    public static OrderDetailDao getInstance() {
        if (instance == null) {
            instance = new OrderDetailDaoImpl();
        }
        return instance;
    }

    private OrderDetailDaoImpl() {
    }

    public int insert(OrderDetail detail) {

        int result = -1;

        String sql = "insert into t_order_detail (order_id, product_id, quantity) values (?, ?,?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, detail.getOrderId());
            pstmt.setInt(2, detail.getProductId());
            pstmt.setInt(3, detail.getQuantity());

            result = pstmt.executeUpdate();
            System.out.println(result + "건 입력 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int delete(Integer detailId) {
        int result = -1;

        String sql = "delete from t_order_detail where d_id=?";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setInt(1, detailId);
            // 처리된 건수가 리턴
            result = pstmt.executeUpdate();

            System.out.println(result + "건이 delete 되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public OrderDetail select(Integer detailId) {
        OrderDetail tempOrderDetail = new OrderDetail();

        String sql = "select * from t_order_detail where d_id=? order by order_id desc";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setInt(1, detailId);
            ResultSet rs = pstmt.executeQuery();
            // 처리된 건수가 리턴
            while (rs.next()) {

                Integer id = rs.getInt(1);
                Integer orderId = rs.getInt(2);
                Integer productId = rs.getInt(3);
                Integer quantity = rs.getInt(4);

                tempOrderDetail.setId(id);
                tempOrderDetail.setOrderId(orderId);
                tempOrderDetail.setProductId(productId);
                tempOrderDetail.setQuantity(quantity);

                System.out.println(id + "\t" + orderId + "\t" + productId + "\t" + quantity);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tempOrderDetail;
    }

    @Override
    public List<OrderDetail> selectAll() {
        List<OrderDetail> orderList = new ArrayList<OrderDetail>();

        String sql = "select * from t_order_detail";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();) {

            // 처리된 건수가 리턴
            while (rs.next()) {
                OrderDetail tempOrderDetail = new OrderDetail();
                Integer id = rs.getInt(1);
                Integer orderId = rs.getInt(2);
                Integer productId = rs.getInt(3);
                Integer quantity = rs.getInt(4);

                tempOrderDetail.setId(id);
                tempOrderDetail.setOrderId(orderId);
                tempOrderDetail.setProductId(productId);
                tempOrderDetail.setQuantity(quantity);

                orderList.add(tempOrderDetail);

                System.out.println(id + "\t" + orderId + "\t" + productId + "\t" + quantity);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return orderList;
    }

}
