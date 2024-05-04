create table users
(
    id                bigint auto_increment primary key,
    nickname          varchar(255) not null,
    email             varchar(255) not null unique,
    password          varchar(255) not null,
    registration_date datetime     not null
);

create table outfits
(
    id      bigint auto_increment primary key,
    name    varchar(255) not null,
    user_id bigint       not null,
    constraint fk_user_2
        foreign key (user_id) references users (id)
);

create table clothes_items
(
    id          bigint auto_increment primary key,
    name        varchar(255) not null,
    description text,
    type_id     varchar(50)  not null,
    outfit_id   bigint       not null,
    constraint fk_outfit_3
        foreign key (outfit_id) references outfits (id)
);

create table clothes_photos
(
    id              bigint auto_increment primary key,
    clothes_item_id bigint       not null,
    photo           varchar(255) not null,
    constraint fk_clothes_item_1
        foreign key (clothes_item_id) references clothes_items (id)
);

create table outfit_tags
(
    id        bigint auto_increment primary key,
    outfit_id bigint       not null,
    tag       varchar(255) not null,
    constraint fk_outfit_2
        foreign key (outfit_id) references outfits (id)
);

create table comments
(
    id               bigint auto_increment primary key,
    user_id          bigint      not null,
    outfit_id        bigint      not null,
    comment_text     text        not null,
    rate             varchar(50) not null,
    date_of_creation datetime    not null,
    constraint fk_user_1
        foreign key (user_id) references users (id),
    constraint fk_outfit_1
        foreign key (outfit_id) references outfits (id)
);
