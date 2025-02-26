-- Inserir dados na tabela orders
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('João', 'PENDENTE', 'PIX', 'Rua A, 123, São Paulo');
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('Maria', 'CONCLUIDO', 'CARTAO_CREDITO', 'Av. B, 456, Rio de Janeiro');
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('Carlos', 'PENDENTE', 'DINHEIRO', 'Rua C, 789, Belo Horizonte');
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('Ana', 'CONCLUIDO', 'CARTAO_DEBITO', 'Av. D, 321, Porto Alegre');
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('Erick', 'PENDENTE', 'PIX', 'Samambaia Sul, Brasília - DF');

-- Inserir dados na tabela order_items
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 1', 2, 10.5, 1);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 2', 1, 20.0, 1);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 3', 3, 15.75, 2);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 4', 5, 7.99, 3);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 5', 2, 30.0, 4);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 6', 1, 50.0, 4);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Iphone 15', 1, 4000.00, 5);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Teclado mecânico', 1, 250.90, 5);