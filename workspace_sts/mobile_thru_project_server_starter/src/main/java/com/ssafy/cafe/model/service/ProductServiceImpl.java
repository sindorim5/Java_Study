package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.cafe.model.dao.ProductDao;
import com.ssafy.cafe.model.dto.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
    @Override
    public List<Product> getProductList() {
        return productDao.selectAll();
    }

    @Override
    public List<Map<String, Object>> selectWithComment(Integer productId) {
        return productDao.selectWithComment(productId);
    }

}
