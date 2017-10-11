-- users
-- login = password
INSERT INTO users (username, name, lastname, email, password)
VALUES ('admin', 'name', 'lastname', '@', '$2a$06$3BHW3i/tVjeNmAhORQ0u8.fL.EbGSX2JSqrtw61NzV/TJR0vAJa8W'),
  ('test', 'name', 'lastname', '@', '$2a$06$ZbDBuVr41088Gaz.z.6E2.8gPne1fy11fT2tbu5A/1k5mUHswuv3i');

-- roles
INSERT INTO roles (name)
VALUES ('ADMIN'), ('CUSTOMER');

-- users_roles
INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 1), (2, 2);

-- products
INSERT INTO products (name, price, description)
VALUES ('Akai BT100', 10000, 'description'),
  ('Телескоп Levenhuk Skyline', 60000, 'description'),
  ('Камера GoPro', 2000,
   'Экшн-камера - позволяет записывать с разрешением 4К и очень плавным изображением до 25 кадров в секунду с дисплеем 2″ TFT LCD.'),
  ('Велосипед EzCity', 1000, 'description'),
  ('Палатка North',	540, 'description'),
  ('Наушники Sony ',	444, 'description');

-- orders
INSERT INTO orders (users_id)
VALUES (1), (2);

-- shopping cart
INSERT INTO shopping_cart (users_id, orders_id) VALUES (1, 1), (2, 2);

-- orders_items
INSERT INTO orders_items (orders_id, products_id, count) VALUES (1, 2, 10), (1, 4, 5), (2, 1, 7);


