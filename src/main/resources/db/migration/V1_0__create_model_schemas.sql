CREATE TABLE if not exists users (
user_id int primary key not null auto_increment,
name varchar(255) not null);

create table if not exists files(
file_id int primary key not null auto_increment,
name varchar(255) not null,
location varchar(255) not null,
created DATE not null);

create table if not exists events(
event_id int primary key not null auto_increment);