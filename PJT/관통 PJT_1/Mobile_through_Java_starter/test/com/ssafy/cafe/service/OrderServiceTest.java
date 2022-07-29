package com.ssafy.cafe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.OrderDetail;


class OrderServiceTest extends AbstractServiceTest {

    @Test
    @org.junit.jupiter.api.Order(1)
    void makeOrderTest() {
        Order order = new Order(user.getId(), "table_test", new Date(), 'N');
        List<OrderDetail> details = new ArrayList<>();
        details.add(new OrderDetail(1, 1));
        details.add(new OrderDetail(2, 2));
        details.add(new OrderDetail(2, 2));
        order.setDetails(details);
        
        orderService.makeOrder(order);
    }
    
    static Order last;
    @Test
    @org.junit.jupiter.api.Order(2)
    void getOrderByUserTest() {
        List<Order> orders = orderService.getOrdreByUser(user.getId());
        System.out.println(last);
        last = orders.get(0);
        assertEquals("table_test", last.getOrderTable() );
        
        orders = orderService.getOrdreByUser("id 02");
        assertEquals(1, orders.size());
    }
    
    
    @Test
    @org.junit.jupiter.api.Order(3)
    void getOrderWithDetailsTest() {
        Order order = orderService.getOrderWithDetails(last.getId());
        assertEquals(last.getUserId(), order.getUserId());
        assertEquals(last.getOrderTable(), order.getOrderTable());
        List<OrderDetail> details = order.getDetails();
        assertEquals(3, details.size());
        assertEquals(2, (int)details.get(0).getQuantity());
        last = order;
    }


    
    @Test
    @org.junit.jupiter.api.Order(4)
    void updateOrderTest() {
        assertEquals('N', (char)last.getCompleted());
        last.setCompleted('Y');
        orderService.updateOrder(last);
        Order order = orderService.getOrderWithDetails(last.getId());
        assertEquals('Y', (char)order.getCompleted());
    }
    
    @Test
    @org.junit.jupiter.api.Order(5)
    void deleteOrderTest() {
        List<OrderDetail> details = last.getDetails();
        for(OrderDetail detail: details) {
            dDao.delete(detail.getId());
        }
        dDao.delete(last.getId());
    }

}
