package com.ssafy.cafe.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ssafy.cafe.model.dao.OrderDao;
import com.ssafy.cafe.model.dao.OrderDaoImpl;
import com.ssafy.cafe.model.dao.OrderDetailDao;
import com.ssafy.cafe.model.dao.OrderDetailDaoImpl;
import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.OrderDetail;
import com.ssafy.cafe.util.DBUtil;

public class OrderServiceImpl implements OrderService {
    OrderDao orderMgr = OrderDaoImpl.getInstance();
    OrderDetailDao orderDetailMgr = OrderDetailDaoImpl.getInstance();

    private static OrderServiceImpl instance;

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    private OrderServiceImpl() {

    }

    public void makeOrder(Order order) {
        System.out.println(order);
         orderMgr.insert(order);
         int orderId = orderMgr.selectByUser(order.getUserId()).get(0).getId();
         
         List<OrderDetail> detailList = order.getDetails();

        for (OrderDetail detail : detailList) {
            detail.setOrderId(orderId);
            orderDetailMgr.insert(detail);
        }
    }

    @Override
    public Order getOrderWithDetails(Integer orderId) {
        Order tempOrder = orderMgr.select(orderId);
        List<OrderDetail> detailList = new ArrayList<>();
        int result = -1;

        String sql = "select * from t_order_detail where order_id=? order by d_id desc";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                OrderDetail tempDetail = new OrderDetail();

                int dId = rs.getInt(1);
                int order_Id = rs.getInt(2);
                int productId = rs.getInt(3);
                int quantity = rs.getInt(4);

                tempDetail.setId(dId);
                tempDetail.setOrderId(order_Id);
                tempDetail.setProductId(productId);
                tempDetail.setQuantity(quantity);

                detailList.add(tempDetail);

            }
            tempOrder.setDetails(detailList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tempOrder;
    }

    @Override
    public List<Order> getOrdreByUser(String id) {
        List<Order> tempOrderList = new ArrayList<Order>();
        tempOrderList = orderMgr.selectByUser(id);
        return tempOrderList;
    }

    @Override
    public void updateOrder(Order order) {
        orderMgr.update(order);

    }

    @Override
    public List<Map> selectOrderTotalInfo(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
