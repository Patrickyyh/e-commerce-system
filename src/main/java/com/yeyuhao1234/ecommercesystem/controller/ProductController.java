package com.yeyuhao1234.ecommercesystem.controller;

import com.yeyuhao1234.ecommercesystem.entity.Product;
import com.yeyuhao1234.ecommercesystem.entity.ProductCommentCreated;
import com.yeyuhao1234.ecommercesystem.model.*;
import com.yeyuhao1234.ecommercesystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private EntityManager entityManager;

    // Fetch all the comment of the product which rating is above by a number
    @GetMapping("/comment/aboveRating")
    public List<ProductCommentRating>fetchCommentByRatingLarger(@RequestParam(value = "aboveRating") long aboveRating){
        return productService.fetchCommentByRatingLarger(aboveRating);
    }


    //Get Product by Id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long id){
        ProductResponse productResponse = productService.getProductById(id);
        return new ResponseEntity<>(productResponse , HttpStatus.OK);
    }


    // GET product by the price range
    @GetMapping("/abovePrice")
    public List<ProductResponse> fetchUserByPriceLarger(@RequestParam(value = "abovePrice") long abovePrice){
        List<Object []> resultList =
                entityManager.createNativeQuery(" SELECT product_id, name, price ,description , rating" +
                        " From product WHERE price > " + abovePrice).getResultList();
        List<ProductResponse> products = new ArrayList<>();
        for (Object [] v1 : resultList){
            ProductResponse result = ProductResponse.builder()
                    .productId(Long.parseLong(String.valueOf(v1[0])))
                    .name(String.valueOf(v1[1]))
                    .price(Long.parseLong(String.valueOf(v1[2])))
                    .description(String.valueOf(v1[3]))
                    .rating(Long.parseLong(String.valueOf(v1[4])))
                    .build();
            products.add(result);
        }

        return products;
//        return productService.fetchUserByPriceLarger(abovePrice);
    }

    // fetch product by both price and rating
    @GetMapping("/priceandrating")
    public List<ProductRatingPrice> fetchUserBypPriceRating(@RequestParam List<Long> priceandrating){
            long price = priceandrating.get(0);
            long rating = priceandrating.get(1);
            return productService.fetchUserByPriceAndRating(price ,rating);
        }


      //Fetch all the products
    @GetMapping("/")
    public List<ProductFullResponse> fetchAllProducts(){
        return productService.fetchAllProducts();
    }

    // Fetch all the ProductStats
    @GetMapping("/productStats")
    public List<ProductStatResponse>fetchAllProductStats(){
        List<Object []> resultList =
                entityManager.createNativeQuery("SELECT product.product_id ,product.product_stat_id " +
                        " ,name, yearly_total_sold_units , years_sales_total FROM (" +
                        " product INNER JOIN product_stat ON product.product_stat_id = product_stat.product_stat_id)").getResultList();
        List<ProductStatResponse> productStat = new ArrayList<>();
        for (Object [] v1 : resultList){
            ProductStatResponse result = ProductStatResponse.builder()
                    .productId(Long.parseLong(String.valueOf(v1[0])))
                    .productStatId(Long.parseLong(String.valueOf(v1[1])))
                    .name(String.valueOf(v1[2]))
                    .yearlyTotalSoldUnits(Long.parseLong(String.valueOf(v1[3])))
                    .yearsSalesTotal(Long.parseLong(String.valueOf(v1[4])))
                    .build();
            productStat.add(result);
        }

        return productStat;
    }

    // Fetch productStats by years total sales
    @GetMapping("/productStats/yearsSalesTotal")
    public List <ProductStatyearSalesTotalResponse>fetchProductStatByYearSalesTotal(
            @RequestParam(value = "yearsSalesTotal") long yearsStotal ){
        List<Object []> resultList =
                entityManager.createNativeQuery("SELECT product.product_id ,product.product_stat_id " +
                                ",name, yearly_total_sold_units , years_sales_total FROM (" +
                                " product INNER JOIN product_stat ON product.product_stat_id = product_stat.product_stat_id) " +
                                " GROUP BY product_id HAVING years_sales_total > " + yearsStotal)
                        .getResultList();

        List<ProductStatyearSalesTotalResponse> products = new ArrayList<>();
        for(Object [] v1 : resultList){
            ProductStatyearSalesTotalResponse result =
                    ProductStatyearSalesTotalResponse.builder()
                            .productId(Long.parseLong(String.valueOf(v1[0])))
                            .productStatId(Long.parseLong(String.valueOf(v1[1])))
                            .name(String.valueOf(v1[2]))
                            .yearlyTotalSoldUnits(Long.parseLong(String.valueOf(v1[3])))
                            .yearsSalesTotal(Long.parseLong(String.valueOf(v1[4])))
                            .build();
            products.add(result);
        }

        return products;
    }



}
