SELECT * FROM ecommercedb.product_comment_created;
SELECT * FROM product;


-- Using subquery over here 
SELECT comment_id , content FROM product_comment_created
WHERE product_comment_created.product_id IN
(SELECT product_id From product
	WHERE product.rating > 9
);

