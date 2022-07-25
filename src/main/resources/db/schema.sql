CREATE TABLE if not exists users
(
    id serial primary key,
    username VARCHAR(255)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled  boolean default true,
    role VARCHAR(255) NOT NULL
);

create table if not exists answers
(
    id          serial primary key,
    created     timestamp,
    text varchar(255),
    post_id     INTEGER REFERENCES posts(id),
    user_id     INTEGER REFERENCES users(id)
);

create table if not exists posts
(
    id          serial primary key,
    created     timestamp,
    description varchar(255),
    name        varchar(255),
    updated     timestamp,
    user_id     INTEGER REFERENCES users(id)
);