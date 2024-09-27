create table category_data
(
    id   bigint       not null
        primary key,
    name varchar(255) not null
);

create table category_data_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table product_data
(
    active      tinyint       not null,
    price       float         not null,
    stock       int           not null,
    category_id bigint        not null,
    id          bigint        not null
        primary key,
    description mediumtext    null,
    image       varchar(1000) null,
    name        varchar(500)  not null,
    sku         varchar(100)  not null,
    constraint FKjcng5rm3s3ldpk857gvjmp0x7
        foreign key (category_id) references category_data (id)
);

create table product_data_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

create table user_data
(
    is_admin tinyint      not null,
    id       bigint       not null
        primary key,
    email    varchar(255) not null,
    password varchar(255) not null,
    role     varchar(255) null,
    username varchar(255) not null
);

create table user_data_seq
(
    next_not_cached_value bigint(21)          not null,
    minimum_value         bigint(21)          not null,
    maximum_value         bigint(21)          not null,
    start_value           bigint(21)          not null comment 'start value when sequences is created or value if RESTART is used',
    increment             bigint(21)          not null comment 'increment value',
    cache_size            bigint(21) unsigned not null,
    cycle_option          tinyint(1) unsigned not null comment '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
    cycle_count           bigint(21)          not null comment 'How many cycles have been done'
);

