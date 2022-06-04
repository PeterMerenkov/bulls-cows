create table game
(
    id integer not null,
    username varchar(255) not null,
    time bigint not null,
    steps integer not null,
    isTimeLimit boolean not null,
    isStepLimit boolean not null,
    isWin boolean not null,
    primary key(id)
);