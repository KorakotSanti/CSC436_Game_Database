create database game_database;

use game_database;

create table developer(
dev_id int primary key,
dev_name varchar(50) not null,
year_established char(4)
);

create table publisher(
pub_id int primary key,
pub_name varchar(50) not null,
year_established char(4)
);

create Table game(
game_id int primary key,
game_name varchar(50) not null,
q_rating char(6),
m_rating varchar(8),
dev_id int not null,
pub_id int not null,
foreign key(dev_id) references developer(dev_id),
foreign key(pub_id) references publisher(pub_id)
);

create table genre(
genre_id int primary key,
genre_name varchar(30) not null
);

create table platform(
platform_id int primary key,
platform_name varchar(30) not null
);

create table game_genre(
game_id int,
genre_id int,
foreign key(game_id) references game(game_id) on delete cascade,
foreign key(genre_id) references genre(genre_id) on delete cascade
);

create table game_platform(
game_id int not null,
platform_id int not null,
foreign key(game_id) references game(game_id) on delete cascade,
foreign key(platform_id) references platform(platform_id) on delete cascade
);

