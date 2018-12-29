CREATE SEQUENCE time_duration_id_seq;
create table time_duration (
  id bigint not null DEFAULT NEXTVAL('time_duration_id_seq'),
  parking_min varchar(255) not NULL,
  parking_days varchar(255) not NULL,
  car_id bigint DEFAULT NULL,
  primary key (id),
  CONSTRAINT fk_car
    FOREIGN KEY (car_id)
    REFERENCES cars (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
ALTER SEQUENCE time_duration_id_seq OWNED BY time_duration.id;