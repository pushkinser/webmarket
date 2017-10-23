-- --
-- -- PostgreSQL database dump
-- --
--
-- -- Dumped from database version 9.6.5
-- -- Dumped by pg_dump version 9.6.5
--
-- -- Started on 2017-10-10 19:42:30
--
-- SET statement_timeout = 0;
-- SET lock_timeout = 0;
-- SET idle_in_transaction_session_timeout = 0;
-- SET client_encoding = 'UTF8';
-- SET standard_conforming_strings = on;
-- SET check_function_bodies = false;
-- SET client_min_messages = warning;
-- SET row_security = off;
--
-- --
-- -- TOC entry 1 (class 3079 OID 12387)
-- -- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
-- --
--
-- CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
--
--
-- --
-- -- TOC entry 2208 (class 0 OID 0)
-- -- Dependencies: 1
-- -- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
-- --
--
-- COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
--
--
-- SET search_path = public, pg_catalog;
--
-- SET default_tablespace = '';
--
-- SET default_with_oids = false;
--
-- --
-- -- TOC entry 185 (class 1259 OID 17984)
-- -- Name: categories; Type: TABLE; Schema: public; Owner: postgres
-- --

CREATE TABLE categories (
  categories_id integer NOT NULL,
  name character varying(255)
);


ALTER TABLE categories OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 17987)
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
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 186
-- Name: categories_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE categories_categories_id_seq OWNED BY categories.categories_id;


--
-- TOC entry 187 (class 1259 OID 17989)
-- Name: orders_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE orders_items (
  orders_id integer NOT NULL,
  products_id integer NOT NULL,
  count integer,
  orders_items_id integer NOT NULL
);


ALTER TABLE orders_items OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 17992)
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
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 188
-- Name: order_items_order_items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE order_items_order_items_id_seq OWNED BY orders_items.orders_id;


--
-- TOC entry 189 (class 1259 OID 17994)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE orders (
  orders_id integer NOT NULL,
  users_id integer,
  address character varying(255)
);


ALTER TABLE orders OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 26331)
-- Name: orders_items_orders_items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE orders_items_orders_items_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;


ALTER TABLE orders_items_orders_items_id_seq OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 201
-- Name: orders_items_orders_items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE orders_items_orders_items_id_seq OWNED BY orders_items.orders_items_id;


--
-- TOC entry 190 (class 1259 OID 18000)
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
-- Dependencies: 190
-- Name: orders_orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE orders_orders_id_seq OWNED BY orders.orders_id;


--
-- TOC entry 192 (class 1259 OID 18007)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE products (
  products_id integer NOT NULL,
  name character varying(255),
  price numeric,
  description character varying(255)
);


ALTER TABLE products OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 18002)
-- Name: products_categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE products_categories (
  products_id integer NOT NULL,
  categories_id integer NOT NULL
);


ALTER TABLE products_categories OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 18013)
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
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 193
-- Name: products_products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE products_products_id_seq OWNED BY products.products_id;


--
-- TOC entry 194 (class 1259 OID 18015)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE roles (
  roles_id integer NOT NULL,
  name character varying(50) NOT NULL
);


ALTER TABLE roles OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 18018)
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
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 195
-- Name: roles_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_role_id_seq OWNED BY roles.roles_id;


--
-- TOC entry 196 (class 1259 OID 18020)
-- Name: shopping_cart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE shopping_cart (
  shopping_cart_id integer NOT NULL,
  users_id integer,
  orders_id integer
);


ALTER TABLE shopping_cart OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 18023)
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
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 197
-- Name: shopping_cart_shopping_cart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE shopping_cart_shopping_cart_id_seq OWNED BY shopping_cart.shopping_cart_id;


--
-- TOC entry 198 (class 1259 OID 18025)
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
-- TOC entry 199 (class 1259 OID 18031)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users_roles (
  users_id integer NOT NULL,
  roles_id integer NOT NULL
);


ALTER TABLE users_roles OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 18034)
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
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 200
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_user_id_seq OWNED BY users.users_id;


--
-- TOC entry 2050 (class 2604 OID 18036)
-- Name: categories categories_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categories ALTER COLUMN categories_id SET DEFAULT nextval('categories_categories_id_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 18038)
-- Name: orders orders_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders ALTER COLUMN orders_id SET DEFAULT nextval('orders_orders_id_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 18037)
-- Name: orders_items orders_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items ALTER COLUMN orders_id SET DEFAULT nextval('order_items_order_items_id_seq'::regclass);


--
-- TOC entry 2052 (class 2604 OID 26333)
-- Name: orders_items orders_items_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items ALTER COLUMN orders_items_id SET DEFAULT nextval('orders_items_orders_items_id_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 18040)
-- Name: products products_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products ALTER COLUMN products_id SET DEFAULT nextval('products_products_id_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 18041)
-- Name: roles roles_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN roles_id SET DEFAULT nextval('roles_role_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 18042)
-- Name: shopping_cart shopping_cart_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart ALTER COLUMN shopping_cart_id SET DEFAULT nextval('shopping_cart_shopping_cart_id_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 18043)
-- Name: users users_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN users_id SET DEFAULT nextval('users_user_id_seq'::regclass);


--
-- TOC entry 2059 (class 2606 OID 18045)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categories
  ADD CONSTRAINT categories_pkey PRIMARY KEY (categories_id);


--
-- TOC entry 2061 (class 2606 OID 26339)
-- Name: orders_items orders_items_orders_items_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items
  ADD CONSTRAINT orders_items_orders_items_id_pk PRIMARY KEY (orders_items_id);


--
-- TOC entry 2063 (class 2606 OID 18049)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
  ADD CONSTRAINT orders_pkey PRIMARY KEY (orders_id);


--
-- TOC entry 2065 (class 2606 OID 18110)
-- Name: products_categories products_categories_products_id_categories_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products_categories
  ADD CONSTRAINT products_categories_products_id_categories_id_pk PRIMARY KEY (products_id, categories_id);


--
-- TOC entry 2067 (class 2606 OID 18053)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products
  ADD CONSTRAINT products_pkey PRIMARY KEY (products_id);


--
-- TOC entry 2069 (class 2606 OID 18055)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles
  ADD CONSTRAINT roles_pkey PRIMARY KEY (roles_id);


--
-- TOC entry 2071 (class 2606 OID 18057)
-- Name: shopping_cart shopping_cart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart
  ADD CONSTRAINT shopping_cart_pkey PRIMARY KEY (shopping_cart_id);


--
-- TOC entry 2073 (class 2606 OID 18059)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
  ADD CONSTRAINT users_pkey PRIMARY KEY (users_id);


--
-- TOC entry 2075 (class 2606 OID 18061)
-- Name: users_roles users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_roles
  ADD CONSTRAINT users_roles_pkey PRIMARY KEY (users_id, roles_id);


--
-- TOC entry 2077 (class 2606 OID 18122)
-- Name: orders_items order_items_orders_orders_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items
  ADD CONSTRAINT order_items_orders_orders_id_fk FOREIGN KEY (orders_id) REFERENCES orders(orders_id);


--
-- TOC entry 2076 (class 2606 OID 18062)
-- Name: orders_items order_items_products_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders_items
  ADD CONSTRAINT order_items_products_id_fkey FOREIGN KEY (products_id) REFERENCES products(products_id);


--
-- TOC entry 2078 (class 2606 OID 18072)
-- Name: orders orders_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
  ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (users_id) REFERENCES users(users_id);


--
-- TOC entry 2079 (class 2606 OID 18077)
-- Name: products_categories product_categories_categories_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products_categories
  ADD CONSTRAINT product_categories_categories_id_fkey FOREIGN KEY (categories_id) REFERENCES categories(categories_id);


--
-- TOC entry 2080 (class 2606 OID 18082)
-- Name: products_categories product_categories_products_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY products_categories
  ADD CONSTRAINT product_categories_products_id_fkey FOREIGN KEY (products_id) REFERENCES products(products_id);


--
-- TOC entry 2082 (class 2606 OID 18117)
-- Name: shopping_cart shopping_cart_orders_orders_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart
  ADD CONSTRAINT shopping_cart_orders_orders_id_fk FOREIGN KEY (orders_id) REFERENCES orders(orders_id);


--
-- TOC entry 2081 (class 2606 OID 18092)
-- Name: shopping_cart shopping_cart_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY shopping_cart
  ADD CONSTRAINT shopping_cart_user_id_fkey FOREIGN KEY (users_id) REFERENCES users(users_id);


--
-- TOC entry 2083 (class 2606 OID 18097)
-- Name: users_roles user_roles_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_roles
  ADD CONSTRAINT user_roles_role_id_fkey FOREIGN KEY (roles_id) REFERENCES roles(roles_id);


--
-- TOC entry 2084 (class 2606 OID 18102)
-- Name: users_roles user_roles_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users_roles
  ADD CONSTRAINT user_roles_user_id_fkey FOREIGN KEY (users_id) REFERENCES users(users_id);


-- Completed on 2017-10-10 19:42:31

--
-- PostgreSQL database dump complete
--

