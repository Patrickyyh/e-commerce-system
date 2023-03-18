package com.yeyuhao1234.ecommercesystem.repository;

import com.yeyuhao1234.ecommercesystem.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail , Long > {


//@Query(
//        "SELECT  o.userId , u.userName, COUNT(o.userId) AS number " +
//                "FROM OrderDetail o JOIN" +
//                "User u " +
//                "ON u.userId = o.userId" +
//                "GROUP BY o.userId" +
//                "HAVING COUNT(o.userId) > 5"
//)
//public List<Object []> fetchUserByQuantityOfOrder(@Param(value = "quantity") long quantity);


}
