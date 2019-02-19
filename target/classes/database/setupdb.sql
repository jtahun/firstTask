create database helloworld;

create user 'code'@localhost identified by 'code';

grant all privileges on helloworld.* to 'code'@'localhost';

create table message
(
id int NOT NULL  AUTO_INCREMENT,
msg varchar(255) NOT NULL,
primary key (id)
);

insert into message values ('Hello world');

commit;