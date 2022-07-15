create table user (
	id bigint auto_increment primary key,
    fullname varchar(15),
    email varchar(25),
    password varchar(25),
    creation_date date
);