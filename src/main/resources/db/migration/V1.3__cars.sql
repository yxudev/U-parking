CREATE SEQUENCE cars_id_seq;
create table cars (
  id bigint not null DEFAULT NEXTVAL('cars_id_seq'),
  vin varchar(255) not NULL,
  model varchar(255) not NULL,
  type varchar(255) not NULL,
  primary key (id)
);
ALTER SEQUENCE cars_id_seq OWNED BY cars.id;