CREATE TABLE public.persons
(

    id                  bigint       NOT NULL,
    name                varchar(255) NOT NULL,
    last_name           varchar(255) NOT NULL,
    address             varchar(255) NOT NULL,
    age                 int          NULL,
    height              decimal      NULL,
    weight              decimal      NULL,
    PRIMARY KEY (id)
);