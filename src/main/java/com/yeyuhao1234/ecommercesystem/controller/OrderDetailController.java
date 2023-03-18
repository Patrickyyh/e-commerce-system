package com.yeyuhao1234.ecommercesystem.controller;


import com.yeyuhao1234.ecommercesystem.entity.OrderDetail;
import com.yeyuhao1234.ecommercesystem.model.OrderQuantityResponse;
import com.yeyuhao1234.ecommercesystem.model.OrderResponse;
import com.yeyuhao1234.ecommercesystem.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/order")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private EntityManager entityManager;


    @GetMapping("/")
    public List<OrderResponse> fetchAllOrders(){
        List<Object []> resultList =
                entityManager.createNativeQuery("SELECT order_detail.id,order_has_product.product_id , order_detail.user_id " +
                        " FROM " +
                        " ( order_detail INNER JOIN order_has_product " +
                        " ON order_detail.id = order_has_product.order_detail_id " +
                        ")").getResultList();

        List<OrderResponse> orders = new ArrayList<>();
        for(Object [] v1 : resultList){
            OrderResponse result = OrderResponse.builder()
                    .orderId(Long.parseLong(String.valueOf(v1[0])))
                    .productId(Long.parseLong(String.valueOf(v1[1])))
                    .userId(Long.parseLong(String.valueOf(v1[2])))
                    .build();

            orders.add(result);

        }
        return orders;

    }

    //    -- Group by and aggregation
     //   user place the number of the order larger than some number
    @GetMapping("/quantity")
    List<OrderQuantityResponse>fetchUserByQuantityOfOrder()
    {
         List<Object []> resultList =
                 entityManager.createNativeQuery("SELECT o.user_id ,u.user_name, COUNT(o.user_id) FROM " +
                "order_detail o JOIN user u ON u.user_id = o.user_id GROUP BY o.user_id")
                         .getResultList();

         List<OrderQuantityResponse> orders = new ArrayList<>();
         for(Object [] v1: resultList){
             OrderQuantityResponse result = OrderQuantityResponse.builder()
                     .userId(Long.parseLong(String.valueOf(v1[0])))
                     .userName(String.valueOf(v1[1]))
                     .quantity_of_order(Long.parseLong(String.valueOf(v1[2])))
                     .build();
             orders.add(result);
         }

         return orders;
    }


}
