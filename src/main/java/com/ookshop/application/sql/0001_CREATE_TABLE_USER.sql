create table user (
	id bigint auto_increment primary key,
    full_name varchar(35),
    email varchar(25),
    password varchar(25),
    creation_date date
);