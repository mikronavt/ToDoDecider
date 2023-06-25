-- Table: public.task

-- DROP TABLE IF EXISTS public.task;

CREATE TABLE IF NOT EXISTS public.task
(
    name character varying(500) COLLATE pg_catalog."default" NOT NULL
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.task
    OWNER to postgres;