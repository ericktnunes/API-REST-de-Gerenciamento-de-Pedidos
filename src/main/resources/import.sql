-- Inserir dados na tabela orders
INSERT INTO orders (customer_name, status) VALUES ('João', 'Pendente');
INSERT INTO orders (customer_name, status) VALUES ('Maria', 'Concluído');
INSERT INTO orders (customer_name, status) VALUES ('Carlos', 'Pendente');
INSERT INTO orders (customer_name, status) VALUES ('Ana', 'Concluído');

-- Inserir dados na tabela order_items
INSERT INTO order_items (product_name, quantity, price, order_id) VALUES ('Produto 1', 2, 10.5, 1);
INSERT INTO order_items (product_name, quantity, price, order_id) VALUES ('Produto 2', 1, 20.0, 1);
INSERT INTO order_items (product_name, quantity, price, order_id) VALUES ('Produto 3', 3, 15.75, 2);
INSERT INTO order_items (product_name, quantity, price, order_id) VALUES ('Produto 4', 5, 7.99, 3);
INSERT INTO order_items (product_name, quantity, price, order_id) VALUES ('Produto 5', 2, 30.0, 4);
INSERT INTO order_items (product_name, quantity, price, order_id) VALUES ('Produto 6', 1, 50.0, 4);
