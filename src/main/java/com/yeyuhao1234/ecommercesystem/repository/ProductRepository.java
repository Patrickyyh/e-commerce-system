package com.yeyuhao1234.ecommercesystem.repository;


import com.yeyuhao1234.ecommercesystem.entity.Product;
import com.yeyuhao1234.ecommercesystem.entity.ProductCommentCreated;
import com.yeyuhao1234.ecommercesystem.model.ProductResponse;

import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    // Query the product by the price
@Query("SELECT p FROM Product p WHERE p.price > ?1")
public List<Product> findByLargerThanPrice(long price);

// Query the product by the rating
 @Query("SELECT p.productId , p.name,p.description, p.price , p.rating" +
         " FROM Product p " +
         "WHERE p.price < ?1 and p.rating > ?2")
 public List<Object []> findByRatingandPrice(long price , long rating);


    @Query("SELECT p.commentId, p.content,p.product.productId,p.product.rating " +
            "FROM ProductCommentCreated p " +
            "WHERE p.product.productId IN (" +
            "SELECT pt.productId FROM Product pt WHERE pt.rating > :aboveRating)")
    public List<Object []> fetchCommentByRatingLarger(@Param(value = "aboveRating") long aboveRating);

    @Query("SELECT p.productId, p.name, p.description, p.price,p.rating FROM Product p")
    List<Object[]> fetchAllProducts();
}
