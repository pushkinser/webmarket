--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 9.6.5

-- Started on 2017-09-25 13:58:23

/*SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE webmarket;*/
--
-- TOC entry 2206 (class 1262 OID 16594)
-- Name: webmarket; Type: DATABASE; Schema: -; Owner: postgres
--

/*CREATE DATABASE webmarket WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';*/


/*ALTER DATABASE webmarket OWNER TO postgres;*/

--\connect webmarket

/*SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;*/

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

/*CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;*/


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

/*COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';*/


/*SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;*/

--
-- TOC entry 193 (class 1259 OID 17904)
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE categories (
  categories_id integer NOT NULL,
  categories_name character varying(255)
);


ALTER TABLE categories OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 17902)
-- Name: categories_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE categories_categories_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE categories_categories_id_seq OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 192
-- Name: categories_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE categories_categories_id_seq OWNED BY categories.categories_id;


--
-- TOC entry 199 (class 1259 OID 17948)
-- Name: order_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE order_items (
  order_items_id integer NOT NULL,
  products_id integer,
  count integer
);


ALTER TABLE orders_items OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 17946)
-- Name: order_items_order_items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE order_items_order_items_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE order_items_order_items_id_seq OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 198
-- Name: order_items_order_items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE order_items_order_items_id_seq OWNED BY orders_items.order_items_id;


--
-- TOC entry 201 (class 1259 OID 17961)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE orders (
  orders_id integer NOT NULL,
  users_id integer,
  order_items_id integer,
  reckoning numeric
);


ALTER TABLE orders OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 17959)
-- Name: orders_orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE orders_orders_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE orders_orders_id_seq OWNER TO postgres;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 200
-- Name: orders_orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE orders_orders_id_seq OWNED BY orders.orders_id;


--
-- TOC entry 195 (class 1259 OID 17912)
-- Name: product_categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE product_categories (
  product_categories_id integer NOT NULL,
  products_id integer,
  categories_id integer
);


ALTER TABLE products_categories OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 17910)
-- Name: product_categories_product_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE product_categories_product_categories_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE product_categories_product_categories_id_seq OWNER TO postgres;

--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 194
-- Name: product_categories_product_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE product_categories_product_categories_id_seq OWNED BY products_categories.product_categories_id;


--
-- TOC entry 191 (class 1259 OID 17893)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE products (
  products_id integer NOT NULL,
  products_name character varying(255),
  products_price numeric
);


ALTER TABLE products OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 17891)
-- Name: products_products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE products_products_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE products_products_id_seq OWNER TO postgres;

--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 190
-- Name: products_products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE products_products_id_seq OWNED BY products.products_id;


--
-- TOC entry 186 (class 1259 OID 17856)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE roles (
  roles_id integer NOT NULL,
  name character varying(50) NOT NULL
);


ALTER TABLE roles OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 17854)
-- Name: roles_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE roles_role_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE roles_role_id_seq OWNER TO postgres;

--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 185
-- Name: roles_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_role_id_seq OWNED BY roles.roles_id;


--
-- TOC entry 197 (class 1259 OID 17930)
-- Name: shopping_cart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE shopping_cart (
  shopping_cart_id integer NOT NULL,
  users_id integer,
  products_id integer
);


ALTER TABLE shopping_cart OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 17928)
-- Name: shopping_cart_shopping_cart_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE shopping_cart_shopping_cart_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE shopping_cart_shopping_cart_id_seq OWNER TO postgres;

--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 196
-- Name: shopping_cart_shopping_cart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE shopping_cart_shopping_cart_id_seq OWNED BY shopping_cart.shopping_cart_id;


--
-- TOC entry 188 (class 1259 OID 17864)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
  users_id integer NOT NULL,
  username character varying(255) NOT NULL,
  name character varying(255),
  lastname character varying(255),
  email character varying(255),
  password character varying(255)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 17875)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users_roles (
  users_id integer NOT NULL,
  roles_id integer NOT NULL
);


ALTER TABLE users_roles OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 17862)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_user_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE users_user_id_seq OWNER TO postgres;

--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 187
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_user_id_seq OWNED BY users.users_id;


--
-- TOC entry 2053 (class 2604 OID 17907)
-- Name: categories categories_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categories ALTER COLUMN categories_id SET DEFAULT nextval('categories_categories_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 17951)
-- Name: order_items order_items_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items ALTER COLUMN order_items_id SET DEFAULT nextval('order_items_order_items_id_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 17964)
-- Name: orders orders_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders ALTER COLUMN orders_id SET DEFAULT nextval('orders_orders_id_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 17915)
-- Name: product_categories product_categories_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products_categories ALTER COLUMN product_categories_id SET DEFAULT nextval('product_categories_product_categories_id_seq'::regclass);


--
-- TOC entry 2052 (class 2604 OID 17896)
-- Name: products products_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products ALTER COLUMN products_id SET DEFAULT nextval('products_products_id_seq'::regclass);


--
-- TOC entry 2050 (class 2604 OID 17859)
-- Name: roles roles_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN roles_id SET DEFAULT nextval('roles_role_id_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 17933)
-- Name: shopping_cart shopping_cart_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart ALTER COLUMN shopping_cart_id SET DEFAULT nextval('shopping_cart_shopping_cart_id_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 17867)
-- Name: users users_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN users_id SET DEFAULT nextval('users_user_id_seq'::regclass);


--
-- TOC entry 2067 (class 2606 OID 17909)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categories
  ADD CONSTRAINT categories_pkey PRIMARY KEY (categories_id);


--
-- TOC entry 2073 (class 2606 OID 17953)
-- Name: order_items order_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items
  ADD CONSTRAINT order_items_pkey PRIMARY KEY (order_items_id);


--
-- TOC entry 2075 (class 2606 OID 17969)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
  ADD CONSTRAINT orders_pkey PRIMARY KEY (orders_id);


--
-- TOC entry 2069 (class 2606 OID 17917)
-- Name: product_categories product_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products_categories
  ADD CONSTRAINT product_categories_pkey PRIMARY KEY (product_categories_id);


--
-- TOC entry 2065 (class 2606 OID 17901)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
  ADD CONSTRAINT products_pkey PRIMARY KEY (products_id);


--
-- TOC entry 2059 (class 2606 OID 17861)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles
  ADD CONSTRAINT roles_pkey PRIMARY KEY (roles_id);


--
-- TOC entry 2071 (class 2606 OID 17935)
-- Name: shopping_cart shopping_cart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart
  ADD CONSTRAINT shopping_cart_pkey PRIMARY KEY (shopping_cart_id);


--
-- TOC entry 2061 (class 2606 OID 17872)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
  ADD CONSTRAINT users_pkey PRIMARY KEY (users_id);


--
-- TOC entry 2063 (class 2606 OID 17982)
-- Name: users_roles users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_roles
  ADD CONSTRAINT users_roles_pkey PRIMARY KEY (users_id, roles_id);


--
-- TOC entry 2082 (class 2606 OID 17954)
-- Name: order_items order_items_products_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items
  ADD CONSTRAINT order_items_products_id_fkey FOREIGN KEY (products_id) REFERENCES products(products_id);


--
-- TOC entry 2084 (class 2606 OID 17975)
-- Name: orders orders_order_items_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
  ADD CONSTRAINT orders_order_items_id_fkey FOREIGN KEY (order_items_id) REFERENCES orders_items (order_items_id);


--
-- TOC entry 2083 (class 2606 OID 17970)
-- Name: orders orders_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
  ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (users_id) REFERENCES users(users_id);


--
-- TOC entry 2079 (class 2606 OID 17923)
-- Name: product_categories product_categories_categories_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products_categories
  ADD CONSTRAINT product_categories_categories_id_fkey FOREIGN KEY (categories_id) REFERENCES categories(categories_id);


--
-- TOC entry 2078 (class 2606 OID 17918)
-- Name: product_categories product_categories_products_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products_categories
  ADD CONSTRAINT product_categories_products_id_fkey FOREIGN KEY (products_id) REFERENCES products(products_id);


--
-- TOC entry 2081 (class 2606 OID 17941)
-- Name: shopping_cart shopping_cart_products_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart
  ADD CONSTRAINT shopping_cart_products_id_fkey FOREIGN KEY (products_id) REFERENCES products(products_id);


--
-- TOC entry 2080 (class 2606 OID 17936)
-- Name: shopping_cart shopping_cart_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart
  ADD CONSTRAINT shopping_cart_user_id_fkey FOREIGN KEY (users_id) REFERENCES users(users_id);


--
-- TOC entry 2077 (class 2606 OID 17886)
-- Name: users_roles user_roles_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_roles
  ADD CONSTRAINT user_roles_role_id_fkey FOREIGN KEY (roles_id) REFERENCES roles(roles_id);


--
-- TOC entry 2076 (class 2606 OID 17881)
-- Name: users_roles user_roles_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_roles
  ADD CONSTRAINT user_roles_user_id_fkey FOREIGN KEY (users_id) REFERENCES users(users_id);


--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-09-25 13:58:24

--
-- PostgreSQL database dump complete
--


