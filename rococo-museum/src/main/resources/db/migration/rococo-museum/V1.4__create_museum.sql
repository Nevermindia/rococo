create table if not exists museum
(
    id                     binary(16)    unique not null default (UUID_TO_BIN(UUID(), true)),
    title                  varchar(255)   not null,
    description            text          not null,
    city                   varchar(255)  not null,
    geo_id                 binary(16)    not null,
    photo                  longblob      not null,
    primary key (id),
    constraint fk_country_id foreign key (geo_id) references `country` (id)
);