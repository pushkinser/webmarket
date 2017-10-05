-- users
-- login = password
INSERT INTO users (username, name, lastname, email, password)
VALUES ('admin', 'name', 'lastname', '@', '$2a$06$3BHW3i/tVjeNmAhORQ0u8.fL.EbGSX2JSqrtw61NzV/TJR0vAJa8W'),
('test', 'name', 'lastname', '@', '$2a$06$ZbDBuVr41088Gaz.z.6E2.8gPne1fy11fT2tbu5A/1k5mUHswuv3i');

-- roles
INSERT INTO roles (name)
VALUES  ('ADMIN'), ('CUSTOMER');

-- users_roles
INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 1), (2, 2);

-- products
INSERT INTO products (name, price)
VALUES ('Akai BT100', 10000), ('Телескоп Levenhuk Skyline', 40000);