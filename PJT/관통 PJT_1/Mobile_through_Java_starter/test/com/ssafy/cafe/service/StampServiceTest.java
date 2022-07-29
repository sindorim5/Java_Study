package com.ssafy.cafe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.OrderDetail;
import com.ssafy.cafe.model.dto.Stamp;
import com.ssafy.cafe.model.dto.User;


class StampServiceTest extends AbstractServiceTest{
    
    @Test
    @org.junit.jupiter.api.Order(1)
    public void stampTest() {
        User testUser = new User("test", "test", "test", 0);
        userService.join(testUser);
        
        Order order = new Order(testUser.getId(), "table_test", new Date(), 'N');
        List<OrderDetail> details = new ArrayList<>();
        details.add(new OrderDetail(1, 1));
        details.add(new OrderDetail(2, 2));
        details.add(new OrderDetail(2, 2));
        order.setDetails(details);
        
        orderService.makeOrder(order);
        
        order = new Order(testUser.getId(), "table_test", new Date(), 'N');
        details = new ArrayList<>();
        details.add(new OrderDetail(1, 1));
        order.setDetails(details);
        
        orderService.makeOrder(order);
        
        
        User selected = userService.login(testUser.getId(), testUser.getPass());
        assertEquals(6, (int)selected.getStamps());
        
        List<Stamp> stamps = sService.selectByUser("test");
        assertEquals(2, stamps.size());
        assertEquals(1, (int)stamps.get(0).getQuantity());
    }
    
    @Test
    @org.junit.jupiter.api.Order(2)
    public void cleanup() {
       userService.leave("test");
    }
}
