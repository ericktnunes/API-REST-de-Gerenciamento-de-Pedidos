-- Inserir dados na tabela orders
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('João', 'Pendente', 'PIX', 'Rua A, 123, São Paulo');
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('Maria', 'Concluído', 'CARTAO_CREDITO', 'Av. B, 456, Rio de Janeiro');
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('Carlos', 'Pendente', 'DINHEIRO', 'Rua C, 789, Belo Horizonte');
INSERT INTO tb_orders (customer_name, status, payment_method, delivery_address) VALUES ('Ana', 'Concluído', 'CARTAO_DEBITO', 'Av. D, 321, Porto Alegre');

-- Inserir dados na tabela order_items
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 1', 2, 10.5, 1);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 2', 1, 20.0, 1);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 3', 3, 15.75, 2);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 4', 5, 7.99, 3);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 5', 2, 30.0, 4);
INSERT INTO tb_order_items (product_name, quantity, price, order_id) VALUES ('Produto 6', 1, 50.0, 4);
