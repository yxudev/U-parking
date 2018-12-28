CREATE SEQUENCE cars_id_seq;
create table cars (
  id bigint not null DEFAULT NEXTVAL('cars_id_seq'),
  vin varchar(255) not NULL,
  model varchar(255) not NULL,
  type varchar(255) not NULL,
  user_id bigint DEFAULT NULL,
  primary key (id),
  CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

);
ALTER SEQUENCE cars_id_seq OWNED BY cars.id;