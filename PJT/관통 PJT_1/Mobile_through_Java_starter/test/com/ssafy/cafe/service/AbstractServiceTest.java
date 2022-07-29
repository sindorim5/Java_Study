package com.ssafy.cafe.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import com.ssafy.cafe.model.dao.OrderDao;
import com.ssafy.cafe.model.dao.OrderDaoImpl;
import com.ssafy.cafe.model.dao.OrderDetailDao;
import com.ssafy.cafe.model.dao.OrderDetailDaoImpl;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.model.service.CommentService;
import com.ssafy.cafe.model.service.CommentServiceImpl;
import com.ssafy.cafe.model.service.OrderService;
import com.ssafy.cafe.model.service.OrderServiceImpl;
import com.ssafy.cafe.model.service.ProductService;
import com.ssafy.cafe.model.service.ProductServiceImpl;
import com.ssafy.cafe.model.service.StampService;
import com.ssafy.cafe.model.service.UserService;
import com.ssafy.cafe.model.service.UserServiceImpl;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public abstract class AbstractServiceTest {

    public static User user = new User("id 01", "name 01", "pass 01", 0);

    public UserService userService = UserServiceImpl.getInstance();

    public ProductService prodService = ProductServiceImpl.getInstance();

    public OrderService orderService = OrderServiceImpl.getInstance();

    public CommentService cService = CommentServiceImpl.getInstance();

    public StampService sService;
    
    OrderDao oDao = OrderDaoImpl.getInstance();

    OrderDetailDao dDao= OrderDetailDaoImpl.getInstance();
}
