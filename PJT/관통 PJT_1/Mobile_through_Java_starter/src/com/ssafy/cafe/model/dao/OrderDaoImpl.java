package com.ssafy.cafe.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

    private static OrderDao instance;

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }

    private OrderDaoImpl() {
    }

    public int insert(Order order) {

        int result = -1;

        String sql = "insert into t_order (user_Id, order_table, order_time, completed) values (?,?,?,?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, order.getUserId());
            pstmt.setString(2, order.getOrderTable());
            pstmt.setDate(3, new java.sql.Date(order.getOrderTime().getTime()));
            pstmt.setString(4, order.getCompleted().toString());

            result = pstmt.executeUpdate();
            System.out.println(result + "건 입력 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(Order order) {
        int result = -1;
        String sql = "update t_order set completed = ? where o_id = ?";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, order.getCompleted().toString());
            pstmt.setInt(2, order.getId());
            // 처리된 건수가 리턴
            result = pstmt.executeUpdate();

            System.out.println(result + "건이 update 되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer orderId) {

        int result = -1;

        String sql = "delete from t_order where o_id=?";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setInt(1, orderId);
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
    public Order select(Integer orderId) {
        Order tempOrder = new Order();

        String sql = "select * from t_order where o_id=?";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            // 처리된 건수가 리턴
            while (rs.next()) {

                Integer id = rs.getInt(1);
                String userId = rs.getString(2);
                String orderTable = rs.getString(3);
                Date orderTime = rs.getDate(4);
                String completedChar = rs.getString(5);

                Character completed = completedChar.charAt(0);

                tempOrder.setId(id);
                tempOrder.setUserId(userId);
                tempOrder.setOrderTable(orderTable);
                tempOrder.setOrderTime(orderTime);
                tempOrder.setCompleted(completed);

                System.out.println(id + "\t" + userId + "\t" + orderTable + "\t" + orderTime + "\t" + completed);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tempOrder;
    }

    @Override
    public List<Order> selectAll() {
        List<Order> orderList = new ArrayList<Order>();

        String sql = "select * from t_order";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();) {

            // 처리된 건수가 리턴
            while (rs.next()) {
                Order tempOrder = new Order();
                Integer id = rs.getInt(1);
                String userId = rs.getString(2);
                String orderTable = rs.getString(3);
                Date orderTime = rs.getDate(4);
                String completedChar = rs.getString(5);
                Character completed = completedChar.charAt(0);

                tempOrder.setId(id);
                tempOrder.setUserId(userId);
                tempOrder.setOrderTable(orderTable);
                tempOrder.setOrderTime(orderTime);
                tempOrder.setCompleted(completed);

                orderList.add(tempOrder);

                System.out.println(id + "\t" + userId + "\t" + orderTable + "\t" + orderTime + "\t" + completed);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return orderList;
    }

    @Override
    public Order selectWithDetail(int id) {
        Order tempOrder = new Order();

        String sql = "select * from t_order where o_id=?";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            // 처리된 건수가 리턴
            while (rs.next()) {

                Integer orderId = rs.getInt(1);
                String userId = rs.getString(2);
                String orderTable = rs.getString(3);
                Date orderTime = rs.getDate(4);
                String completedChar = rs.getString(5);

                Character completed = completedChar.charAt(0);

                tempOrder.setId(orderId);
                tempOrder.setUserId(userId);
                tempOrder.setOrderTable(orderTable);
                tempOrder.setOrderTime(orderTime);
                tempOrder.setCompleted(completed);

                System.out.println(id + "\t" + userId + "\t" + orderTable + "\t" + orderTime + "\t" + completed);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tempOrder;
    }

    @Override
    public List<Order> selectByUser(String userId) {
        List<Order> orderList = new ArrayList<Order>();

        String sql = "select * from t_order where user_id = ? order by o_id desc";
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            // 처리된 건수가 리턴
            while (rs.next()) {
                Order tempOrder = new Order();

                Integer orderId = rs.getInt(1);
                String receivedUserId = rs.getString(2);
                String orderTable = rs.getString(3);
                Date orderTime = rs.getDate(4);
                String completedChar = rs.getString(5);

                Character completed = completedChar.charAt(0);

                tempOrder.setId(orderId);
                tempOrder.setUserId(receivedUserId);
                tempOrder.setOrderTable(orderTable);
                tempOrder.setOrderTime(orderTime);
                tempOrder.setCompleted(completed);
                
                orderList.add(tempOrder);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return orderList;
    }

}
