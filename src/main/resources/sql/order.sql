create table if not exists order00
(
    id        int auto_increment
        primary key,
    item_name varchar(1024) null,
    price     varchar(1024) null
)
    comment '订单';