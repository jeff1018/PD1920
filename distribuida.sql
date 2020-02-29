--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.20
-- Dumped by pg_dump version 9.5.20

-- Started on 2020-02-29 01:12:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 7 (class 2615 OID 2200)
-- Name: distribudia; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA distribudia;


ALTER SCHEMA distribudia OWNER TO postgres;

--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA distribudia; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA distribudia IS 'standard public schema';


--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16535)
-- Name: company; Type: TABLE; Schema: distribudia; Owner: postgres
--

CREATE TABLE distribudia.company (
    id integer NOT NULL,
    name character varying,
    catch_phrase character varying,
    bs character varying
);


ALTER TABLE distribudia.company OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16538)
-- Name: direccion; Type: TABLE; Schema: distribudia; Owner: postgres
--

CREATE TABLE distribudia.direccion (
    street character varying,
    suite character varying,
    city character varying,
    zipcode character varying,
    id integer NOT NULL,
    id_geo integer
);


ALTER TABLE distribudia.direccion OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16541)
-- Name: geo; Type: TABLE; Schema: distribudia; Owner: postgres
--

CREATE TABLE distribudia.geo (
    id integer NOT NULL,
    lat character varying,
    lng character varying
);


ALTER TABLE distribudia.geo OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16532)
-- Name: todo; Type: TABLE; Schema: distribudia; Owner: postgres
--

CREATE TABLE distribudia.todo (
    id integer NOT NULL,
    name character varying,
    username character varying,
    email character varying,
    phone character varying,
    website character varying,
    id_company integer,
    id_direccion integer
);


ALTER TABLE distribudia.todo OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16587)
-- Name: usuario; Type: TABLE; Schema: distribudia; Owner: postgres
--

CREATE TABLE distribudia.usuario (
    id integer,
    user_id integer,
    title character varying,
    completed character varying
);


ALTER TABLE distribudia.usuario OWNER TO postgres;

--
-- TOC entry 2126 (class 0 OID 16535)
-- Dependencies: 182
-- Data for Name: company; Type: TABLE DATA; Schema: distribudia; Owner: postgres
--

COPY distribudia.company (id, name, catch_phrase, bs) FROM stdin;
1	Romagiera-Crona	Muitl_layered	harness real-time
\.


--
-- TOC entry 2127 (class 0 OID 16538)
-- Dependencies: 183
-- Data for Name: direccion; Type: TABLE DATA; Schema: distribudia; Owner: postgres
--

COPY distribudia.direccion (street, suite, city, zipcode, id, id_geo) FROM stdin;
kulas ligth	Apt. 556	Ecuador	92998-3874	1	1
\.


--
-- TOC entry 2128 (class 0 OID 16541)
-- Dependencies: 184
-- Data for Name: geo; Type: TABLE DATA; Schema: distribudia; Owner: postgres
--

COPY distribudia.geo (id, lat, lng) FROM stdin;
1	-37.3159	81.14
\.


--
-- TOC entry 2125 (class 0 OID 16532)
-- Dependencies: 181
-- Data for Name: todo; Type: TABLE DATA; Schema: distribudia; Owner: postgres
--

COPY distribudia.todo (id, name, username, email, phone, website, id_company, id_direccion) FROM stdin;
1	Leanne Graham	Bret	Sinvered@april.biz	3452-179	hildegard.org	1	1
\.


--
-- TOC entry 2129 (class 0 OID 16587)
-- Dependencies: 185
-- Data for Name: usuario; Type: TABLE DATA; Schema: distribudia; Owner: postgres
--

COPY distribudia.usuario (id, user_id, title, completed) FROM stdin;
1	1	Linking Park	false
\.


--
-- TOC entry 2003 (class 2606 OID 16567)
-- Name: company_pkey; Type: CONSTRAINT; Schema: distribudia; Owner: postgres
--

ALTER TABLE ONLY distribudia.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);


--
-- TOC entry 2005 (class 2606 OID 16569)
-- Name: direccion_pkey; Type: CONSTRAINT; Schema: distribudia; Owner: postgres
--

ALTER TABLE ONLY distribudia.direccion
    ADD CONSTRAINT direccion_pkey PRIMARY KEY (id);


--
-- TOC entry 2007 (class 2606 OID 16559)
-- Name: geo_pkey; Type: CONSTRAINT; Schema: distribudia; Owner: postgres
--

ALTER TABLE ONLY distribudia.geo
    ADD CONSTRAINT geo_pkey PRIMARY KEY (id);


--
-- TOC entry 2001 (class 2606 OID 16571)
-- Name: todo_pkey; Type: CONSTRAINT; Schema: distribudia; Owner: postgres
--

ALTER TABLE ONLY distribudia.todo
    ADD CONSTRAINT todo_pkey PRIMARY KEY (id);


--
-- TOC entry 2010 (class 2606 OID 16572)
-- Name: direccion_id_geo_fkey; Type: FK CONSTRAINT; Schema: distribudia; Owner: postgres
--

ALTER TABLE ONLY distribudia.direccion
    ADD CONSTRAINT direccion_id_geo_fkey FOREIGN KEY (id_geo) REFERENCES distribudia.geo(id);


--
-- TOC entry 2008 (class 2606 OID 16577)
-- Name: todo_id_company_fkey; Type: FK CONSTRAINT; Schema: distribudia; Owner: postgres
--

ALTER TABLE ONLY distribudia.todo
    ADD CONSTRAINT todo_id_company_fkey FOREIGN KEY (id_company) REFERENCES distribudia.company(id);


--
-- TOC entry 2009 (class 2606 OID 16582)
-- Name: todo_id_direccion_fkey; Type: FK CONSTRAINT; Schema: distribudia; Owner: postgres
--

ALTER TABLE ONLY distribudia.todo
    ADD CONSTRAINT todo_id_direccion_fkey FOREIGN KEY (id_direccion) REFERENCES distribudia.direccion(id);


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA distribudia; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA distribudia FROM PUBLIC;
REVOKE ALL ON SCHEMA distribudia FROM postgres;
GRANT ALL ON SCHEMA distribudia TO postgres;
GRANT ALL ON SCHEMA distribudia TO PUBLIC;


-- Completed on 2020-02-29 01:12:38

--
-- PostgreSQL database dump complete
--

