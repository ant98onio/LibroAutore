-- Table: public.padrone

-- DROP TABLE public.padrone;

CREATE SCHEMA public;

CREATE TABLE IF NOT EXISTS public.padrone
(
    padrone_id integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cognome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT padrone_pkey PRIMARY KEY (padrone_id)
)

TABLESPACE pg_default;

ALTER TABLE public.padrone
    OWNER to postgres;
-- Table: public.gatto

-- DROP TABLE public.gatto;

CREATE TABLE IF NOT EXISTS public.gatto
(
    gatto_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    razza character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT gatto_pkey PRIMARY KEY (gatto_id)
)

TABLESPACE pg_default;

ALTER TABLE public.gatto
    OWNER to postgres;
-- Table: public.cane

-- DROP TABLE public.cane;

CREATE TABLE IF NOT EXISTS public.cane
(
    cane_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    razza character varying(50) COLLATE pg_catalog."default" NOT NULL,
    padrone_id integer,
    CONSTRAINT cane_pkey PRIMARY KEY (cane_id)
)

TABLESPACE pg_default;

ALTER TABLE public.cane
    OWNER to postgres;



--sequences
-- SEQUENCE: public.padrone_sequence

-- DROP SEQUENCE public.padrone_sequence;

CREATE SEQUENCE public.padrone_sequence
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.padrone_sequence
    OWNER TO postgres;




-- SEQUENCE: public.cane_sequence

-- DROP SEQUENCE public.cane_sequence;

CREATE SEQUENCE public.cane_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.cane_sequence
    OWNER TO postgres;