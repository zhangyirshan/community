create table notification
(
    id bigint auto_increment,
    notifier bigint not null,
    receiver bigint not null,
    NOTIFIER_NAME varchar(100),
    outerId bigint not null,
    OUTER_TITLE varchar(256),
    type int not null,
    status int default 0 not null,
    gmt_create bigint not null,
    constraint notification_pk
        primary key (id)
);

comment on column notification.notifier is '通知人';

comment on column notification.receiver is '接受消息的人';

