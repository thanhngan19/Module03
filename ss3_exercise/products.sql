INSERT INTO customers (customer_name, customer_age)
VALUES ('Minh Quan', 10),
		('Ngoc Oanh', 20),
        ('Hong Ha', 50);

INSERT INTO orders (customer_id, order_date, order_total_price)
VALUES (1, '2006-3-21', NULL),
		(2, '2006-3-23', NULL),
        (1, '2006-3-16', NULL);
        
INSERT INTO products (product_name, product_price)
VALUES ('May Giat', 3),
		('Tu Lanh', 5),
		('Dieu Hoa', 7),
        ('Quat', 1),
        ('Bep Dien', 2);
        
INSERT INTO order_details (order_id, product_id, order_qty)
VALUES (1, 1, 3),
		(1, 3, 7),
        (1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);
        -- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT order_id, order_date, order_total_price
FROM orders;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT c.customer_name, p.product_name
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT c.customer_name
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
WHERE order_id IS NULL;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
SELECT o.order_id, o.order_date, od.order_qty * p.product_price AS total_price
FROM orders o
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id;