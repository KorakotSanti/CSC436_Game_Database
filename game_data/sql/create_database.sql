create database game_database;

use game_database;

create table developer(
dev_id int primary key auto_increment,
dev_name varchar(50) not null unique,
year_established char(4)
);

create table publisher(
pub_id int primary key auto_increment,
pub_name varchar(50) not null unique,
year_established char(4)
);

create Table game(
game_id int primary key auto_increment,
game_name varchar(50) not null unique,
q_rating float,
m_rating varchar(8),
dev_id int not null,
pub_id int not null,
foreign key(dev_id) references developer(dev_id),
foreign key(pub_id) references publisher(pub_id)
);

create table genre(
genre_id int primary key auto_increment,
genre_name varchar(30) not null unique
);

create table platform(
platform_id int primary key auto_increment,
platform_name varchar(30) not null
);

create table game_genre(
game_id int not null,
genre_id int not null,
foreign key(game_id) references game(game_id) on delete cascade,
foreign key(genre_id) references genre(genre_id) on delete cascade
);

create table game_platform(
game_id int not null,
platform_id int not null,
release_date char(10),
foreign key(game_id) references game(game_id) on delete cascade,
foreign key(platform_id) references platform(platform_id) on delete cascade
);