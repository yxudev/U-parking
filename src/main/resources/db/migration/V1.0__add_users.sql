CREATE SEQUENCE users_id_seq;
create table users (
   id bigint not null DEFAULT NEXTVAL('users_id_seq'),
   first_name VARCHAR(255) not NULL,
   last_name VARCHAR(255) not NULL,
   email VARCHAR(255) not NULL,
   password VARCHAR(255) not NULL,
   username VARCHAR(255) not NULL,
   zip_code VARCHAR(255) not NULL,
   date_of_birth varchar(255) not null,
   phone_number varchar(255) not null,
   primary key (id)
);
ALTER SEQUENCE users_id_seq OWNED BY users.id;
