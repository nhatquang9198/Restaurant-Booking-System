
    create table accounts (
       id bigint not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table reservations (
       id bigint not null auto_increment,
        date date,
        approved boolean default false,
        table_id bigint not null,
        restaurant_id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table restaurant_tables (
       id bigint not null auto_increment,
        seats integer,
        restaurant_id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table restaurants (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table reservations 
       add constraint FKlmsyoaj81pfgb83w1jhupfq0g 
       foreign key (table_id) 
       references restaurant_tables (id)

    alter table reservations 
       add constraint FK2tl2cjtd2o3o0nfeekcqfvt70 
       foreign key (restaurant_id) 
       references restaurants (id)

    alter table restaurant_tables 
       add constraint FK1xp9xi4k8gkpatx0tfw7hjix3 
       foreign key (restaurant_id) 
       references restaurants (id)
