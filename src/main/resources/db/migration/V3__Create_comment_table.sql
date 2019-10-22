create table comment
(
    id bigint auto_increment,
    parent_id bigint not null,
    type int not null,
    content varchar(1024),
    commentator bigint not null,
    comment_count int default 0,
    gmt_create bigint,
    gmt_modified bigint not null,
    like_count bigint default 0,
    constraint comment_pk
        primary key (id)
);