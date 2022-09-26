package com.ssafy.cafe.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Order;
import com.ssafy.cafe.model.dto.Product;
import com.ssafy.cafe.model.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/order")
@CrossOrigin("*")
public class OrderRestController {
	
	@Autowired
	OrderService orderService;
	
	@ApiOperation(value = "주문생성", notes = "order 객체를 저장하고 추가된 Order의 id를 반환한다.")
	@PostMapping()
	public int makeOrder(@RequestBody Order order) {
		orderService.makeOrder(order);
		return order.getId();
	}
	
	@ApiOperation(value = "주문상세내역", notes = "{orderId}에 해당하는 주문의 상세 내역을 목록 형태로 반환한다.이 정보는 사용자 정보 화면의 주문 내역 조회에서 사용된다.")
	@GetMapping("/{orderId}")
	public List<Map> orderTotalInfo(@PathVariable("orderId") int id ) {
		return orderService.selectOrderTotalInfo(id);
	}
	
	
}
