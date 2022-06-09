create table game
(
    id bigint not null,
    username varchar(255) not null,
    time bigint,
    steps integer,
    isTimeLimit boolean not null,
    isStepLimit boolean not null,
    isWin boolean,
    primary key(id)
);