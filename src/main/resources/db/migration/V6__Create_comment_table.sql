create table comment
(
    id bigint AUTO_INCREMENT PRIMARY KEY,
    parent_id bigint not null,
    type int not null,
    commentator int not null,
    gmt_create bigint,
    gmt_modified bigint not null,
    like_count bigint default 0
);