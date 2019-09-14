create table Tag (
    id             long not null,
    generationTime long not null,
    title          varchar(128) not null,
    description    varchar(1024) not null,
    style          varchar(512) not null
);
