create table notification
(
    id bigint auto_increment,
    notifier bigint not null,
    receiver bigint not null,
    outerId bigint not null,
    type int not null,
    status int default 0 not null,
    gmt_create bigint not null,
    constraint notification_pk
        primary key (id)
);

comment on column notification.notifier is '通知人';

comment on column notification.receiver is '接受消息的人';

