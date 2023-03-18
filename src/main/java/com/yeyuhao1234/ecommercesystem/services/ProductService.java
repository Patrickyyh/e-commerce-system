package com.yeyuhao1234.ecommercesystem.services;

import com.yeyuhao1234.ecommercesystem.entity.Product;
import com.yeyuhao1234.ecommercesystem.entity.ProductCommentCreated;
import com.yeyuhao1234.ecommercesystem.model.ProductCommentRating;
import com.yeyuhao1234.ecommercesystem.model.ProductFullResponse;
import com.yeyuhao1234.ecommercesystem.model.ProductRatingPrice;
import com.yeyuhao1234.ecommercesystem.model.ProductResponse;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(long product_id);
    List<Product> fetchUserByPriceLarger(long abovePrice);
    List<ProductRatingPrice> fetchUserByPriceAndRating(long price, long rating);
    List<ProductCommentRating> fetchCommentByRatingLarger(long aboveRating);
    List<ProductFullResponse> fetchAllProducts();
}
