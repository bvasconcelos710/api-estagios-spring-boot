INSERT INTO tb_usuario (first_name, last_name, email, password) VALUES ('Bruno', 'Vasconcelos', 'bruno@gmail.com', '$2a$10$LxztmmRaitbbl.Ot6Ldf4u7dPMEBpd6aNU9AQBf648JCR/pnewJxS');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 2);

