drop schema library;
create schema if not exists library;
set global time_zone = '+3:00';
use library;

create table if not exists user_role
(
    id   int primary key auto_increment,
    role varchar(20) not null unique
    );

insert into user_role(role)
values ('Admin'),
       ('User');

create table if not exists app_user
(
    id         int primary key auto_increment,
    login      varchar(254) unique not null,
    password   varchar(255)        not null,
    first_name varchar(20)         not null,
    last_name  varchar(20)         not null,
    role_id    int                 not null,
    is_banned  boolean             not null default false,
    foreign key (role_id) references user_role (id) on delete restrict on update cascade
    );

create table if not exists user_bank_account
(
    iban    varchar(34) primary key,
    cvv     varchar(3) not null,
    user_id int        not null,
    foreign key (user_id) references app_user (id) on delete cascade on update cascade
    );

create table if not exists book
(
    id              int primary key auto_increment,
    name            varchar(20) not null,
    author          varchar(50) not null,
    date_of_writing date        not null,
    price           double      not null,
    price_per_day   double      not null,
    quantity        int         not null,
    preview         mediumtext,
    genre           varchar(20) not null
    );

create table if not exists book_order_status
(
    order_status varchar(20) primary key
    );
insert into book_order_status(order_status)
values ('Completed'),
       ('Failed');


create table if not exists book_order
(
    id                  int primary key auto_increment,
    date_of_creation    date        not null,
    ordered_by          int         not null,
    verified_by         int         not null,
    order_complete_date date,
    order_status        varchar(20) not null,

    foreign key (ordered_by) references app_user (id) on delete cascade on update cascade,
    foreign key (verified_by) references app_user (id) on delete cascade on update cascade,
    foreign key (order_status) references book_order_status (order_status) on delete restrict on update cascade
    );

create table if not exists book_order_book
(
    book_id  int,
    order_id int,
    primary key (book_id, order_id),
    foreign key (book_id) references book (id) on delete cascade on update cascade,
    foreign key (order_id) references book_order (id) on delete cascade on update cascade
    )
