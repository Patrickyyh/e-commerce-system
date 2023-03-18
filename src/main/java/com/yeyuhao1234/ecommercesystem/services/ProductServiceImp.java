package com.yeyuhao1234.ecommercesystem.services;


import com.yeyuhao1234.ecommercesystem.entity.Product;
import com.yeyuhao1234.ecommercesystem.entity.ProductCommentCreated;
import com.yeyuhao1234.ecommercesystem.exception.UserServiceCustomException;
import com.yeyuhao1234.ecommercesystem.model.*;
import com.yeyuhao1234.ecommercesystem.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements  ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductResponse getProductById(long product_id) {

       Product product = productRepository
               .findById(product_id)
               .orElseThrow(()-> new UserServiceCustomException("Product with given id not found" ,"PRODUCT_NOT_FOUND"));
       ProductResponse productResponse = new ProductResponse();
       BeanUtils.copyProperties(product , productResponse);
       return productResponse;

    }
    @Override
    public List<ProductCommentRating> fetchCommentByRatingLarger(long aboveRating) {
       List<Object []> temp = productRepository.fetchCommentByRatingLarger(aboveRating);
       List<ProductCommentRating> products = new ArrayList<>();
       for (Object [] v1 : temp){
           ProductCommentRating product = ProductCommentRating.builder()
                   .commentId((Long) v1[0])
                   .content((String) v1[1])
                   .productId((Long) v1[2])
                   .rating((Long)    v1[3])
                   .build();
           products.add(product);
       }

       return products;
    }

    @Override
    public List<Product> fetchUserByPriceLarger(long abovePrice) {
        return productRepository.findByLargerThanPrice(abovePrice);
    }

    @Override
    public List<ProductRatingPrice> fetchUserByPriceAndRating(long price, long rating) {

        List<Object[]> temp = productRepository.findByRatingandPrice(price , rating);
        List<ProductRatingPrice> products = new ArrayList<>();
        for( Object[] v1 : temp){
            ProductRatingPrice product = ProductRatingPrice.builder()
                    .productId((Long) v1[0])
                    .name((String) v1[1])
                    .description((String) v1[2])
                    .price((Long) v1[3])
                    .rating((Long) v1[4])
                    .build();
            products.add(product);
        }
        return products;
    }

    @Override
    public List<ProductFullResponse> fetchAllProducts() {
        List<Object []> temp = productRepository.fetchAllProducts();
        List<ProductFullResponse> products = new ArrayList<>();
        for(Object[] v1 : temp){
            ProductFullResponse product = ProductFullResponse.builder()
                    .productId((Long) v1[0])
                    .name((String) v1[1])
                    .description((String) v1[2])
                    .price((Long) v1[3])
                    .rating((Long) v1[4])
                    .build();
            products.add(product);
        }
        return products;
    }
}
