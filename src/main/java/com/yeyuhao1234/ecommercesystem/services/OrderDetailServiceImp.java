package com.yeyuhao1234.ecommercesystem.services;

import com.yeyuhao1234.ecommercesystem.model.OrderQuantityResponse;
import com.yeyuhao1234.ecommercesystem.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

//    @Override
//    public List<OrderQuantityResponse> fetchUserByQuantityOfOrder(long quantity) {
//        System.out.println(orderDetailRepository.);
//    }
}
