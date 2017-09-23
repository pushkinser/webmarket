CREATE TABLE roles (
  roleid   SERIAL PRIMARY KEY,
  rolename VARCHAR(50)
);

CREATE TABLE users (
  userid   SERIAL PRIMARY KEY,
  username VARCHAR(255),
  lastname VARCHAR(255),
  email    VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE user_roles (
  userrolesid SERIAL PRIMARY KEY,
  userid      INTEGER,
  roleid      INTEGER,
  FOREIGN KEY (userid) REFERENCES users (userid),
  FOREIGN KEY (roleid) REFERENCES roles (roleid)
);

CREATE TABLE products (
  productid SERIAL PRIMARY KEY,
  label     VARCHAR(255),
  price     MONEY
);

CREATE TABLE categories (
  categoriesid   SERIAL PRIMARY KEY,
  categoriesname VARCHAR(255)
);

CREATE TABLE product_categories (
  productcategories SERIAL PRIMARY KEY,
  productid         INTEGER,
  categoriesid      INTEGER,
  FOREIGN KEY (productid) REFERENCES products (productid),
  FOREIGN KEY (categoriesid) REFERENCES categories (categoriesid)
);

CREATE TABLE shopping_list (
  shopplistid SERIAL PRIMARY KEY,
  productid   INTEGER,
  productamt  INTEGER,
  FOREIGN KEY (productid) REFERENCES products (productid)
);

CREATE TABLE shopping_cart (
  shoppcartid SERIAL PRIMARY KEY,
  userid      INTEGER,
  shopplistid INTEGER,
  FOREIGN KEY (userid) REFERENCES users (userid),
  FOREIGN KEY (shopplistid) REFERENCES shopping_list (shopplistid)
);

CREATE TABLE orders (
  orderid   SERIAL PRIMARY KEY,
  userid    INTEGER,
  orderlist INTEGER,
  reckoning MONEY,
  FOREIGN KEY (userid) REFERENCES users (userid)
);

CREATE TABLE order_list (
  orderlistid SERIAL PRIMARY KEY,
  productid   INTEGER,
  orderid     INTEGER,
  FOREIGN KEY (productid) REFERENCES products (productid),
  FOREIGN KEY (orderid) REFERENCES orders (orderid)
);


-- INSERT INTO users (username, lastname, email, password) VALUES ('Sergey', 'Pushkin', '@', 'password');
-- INSERT INTO roles (rolename) VALUES ('Adnin'), ('User');
