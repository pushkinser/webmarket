
CREATE TABLE roles (
  roleid   SERIAL PRIMARY KEY,
  rolename VARCHAR(50)
);

CREATE TABLE users (
  userid     SERIAL PRIMARY KEY,
  username   VARCHAR(255),
  secondname VARCHAR(255),
  email      VARCHAR(255),
  password   VARCHAR(255)
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

CREATE TABLE pruduct_categories (
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
  shopplisid  INTEGER,
  FOREIGN KEY (userid) REFERENCES users (userid),
  FOREIGN KEY (shopplisid) REFERENCES shopping_list (shopplistid)
);

CREATE TABLE order_list (
  orderlistid SERIAL PRIMARY KEY,
  productid   INTEGER,
  FOREIGN KEY (productid) REFERENCES products (productid)
);

CREATE TABLE orders (
  orderid   SERIAL PRIMARY KEY,
  userid    INTEGER,
  orderlist INTEGER,
  reckoning MONEY,
  FOREIGN KEY (orderlist) REFERENCES order_list (orderlistid),
  FOREIGN KEY (userid) REFERENCES users (userid)
);