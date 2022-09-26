package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.OrderDao;
import com.ssafy.cafe.model.dao.OrderDetailDao;
import com.ssafy.cafe.model.dao.StampDao;
import com.ssafy.cafe.model.dao.UserDao;
import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.OrderDetail;
import com.ssafy.cafe.model.dto.Stamp;
import com.ssafy.cafe.model.dto.User;

@Service
public class OrderServiceImpl implements OrderService {

	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	StampDao stampDao;
	@Autowired
	UserDao userDao;

    @Override
    public void makeOrder(Order order) {
        orderDao.insert(order);
        int id = order.getId();
        for (OrderDetail detail : order.getDetails()) {
        	detail.setOrderId(id);
        	orderDetailDao.insert(detail);
        	Stamp stamp = new Stamp(order.getUserId(),order.getId(),detail.getQuantity());
        	stampDao.insert(stamp);
        }
        int total = 0;
        List<Stamp> stampList = stampDao.selectByUserId(order.getUserId());
        for(Stamp stm : stampList) {
        	total += stm.getQuantity();
        }
        User user = userDao.select(order.getUserId());
        user.setStamps(total);
        userDao.updateStamp(user);
    }

    @Override
    public Order getOrderWithDetails(Integer orderId) {
        return orderDao.selectWithDetail(orderId);
    }

    @Override
    public List<Order> getOrdreByUser(String id) {
        return orderDao.selectByUser(id);
    }

    @Override
    public void updateOrder(Order order) {
		orderDao.update(order);
    }

    @Override
    public List<Map> selectOrderTotalInfo(int id) {
        return orderDao.selectOrderTotalInfo(id);
    }

    @Override
    public List<Map<String, Object>> getLastMonthOrder(String id) {
        return orderDao.getLastMonthOrder(id);
    }

}
