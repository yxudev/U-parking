CREATE SEQUENCE garages_id_seq;
create table garages (
  id bigint not null DEFAULT NEXTVAL('garages_id_seq'),
  garage_name varchar(255) not NULL,
  lot varchar(255) not NULL,
  city varchar(255) not NULL,
  cars_id bigint default null,
  primary key (id),
  CONSTRAINT fk_cars
    FOREIGN KEY (cars_id)
    REFERENCES cars (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

);
ALTER SEQUENCE garages_id_seq OWNED BY garages.id;