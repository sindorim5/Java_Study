package com.ssafy.cafe.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.cafe.model.dao.ProductDao;
import com.ssafy.cafe.model.dao.ProductDaoImpl;
import com.ssafy.cafe.model.dto.Product;

public class ProductServiceImpl implements ProductService{
    
   ProductDao mgr = ProductDaoImpl.getInstance();
   private static ProductService productServiceInstance;
   
   public static ProductService getInstance() {
       if(productServiceInstance == null) {
           productServiceInstance = new ProductServiceImpl();
       }
       return productServiceInstance;
   }
    /**
     * 모든 상품 정보를 반환한다.
     * @return
     */
    public List<Product> getProductList() {
        return mgr.selectAll();
    }
    
   

    /**
     * backend 관통 과정에서 추가됨
     * 상품의 정보, 판매량, 평점 정보를 함께 반환
     * 추후구현. impl class에서는 return null; 로 처리할 것.
     * @param productId
     * @return
     */
    public List<Map<String, Object>> selectWithComment(Integer productId) {
        return null;
    }
}
