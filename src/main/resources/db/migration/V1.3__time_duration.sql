CREATE SEQUENCE time_duration_id_seq;
create table time_duration (
  id bigint not null DEFAULT NEXTVAL('time_duration_id_seq'),
  parking_min varchar(255) not NULL,
  parking_days varchar(255) not NULL,
  users_id bigint DEFAULT NULL,
  primary key (id),
  CONSTRAINT fk_user
    FOREIGN KEY (users_id)
    REFERENCES users (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

);
ALTER SEQUENCE time_duration_id_seq OWNED BY users.id;