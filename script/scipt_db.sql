create table public.config
(
    config_key   varchar(50) not null
        constraint config_pk
            primary key,
    config_value varchar(100),
    status       varchar(1),
    create_by    varchar(32),
    create_date  timestamp default now(),
    update_by    varchar(32),
    update_date  timestamp
);

alter table public.config
    owner to postgres;

create table public.upload_file
(
    file_id     varchar(32) not null
        constraint upload_file_pk
            primary key,
    name        varchar(100),
    path        varchar(100),
    status      integer,
    create_by   varchar(32),
    create_date timestamp default now(),
    update_by   varchar(32),
    update_date integer
);

alter table public.upload_file
    owner to postgres;