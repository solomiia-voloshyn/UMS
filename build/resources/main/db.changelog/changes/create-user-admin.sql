INSERT INTO roles(role)
VALUES ('ADMIN');
INSERT INTO roles(role)
VALUES ('USER');
INSERT INTO users(first_name, last_name, password, status, username)
VALUES ('Admin', 'Admin', '$2a$04$fkyWXsd/e9ZkOSiUDay64euI/bB4L4JuHKLIkIfDepbff8cmFhwOS', 'ACTIVE', 'Admin');
INSERT INTO roles_users(user_id, role_id) VALUES(1, 1);