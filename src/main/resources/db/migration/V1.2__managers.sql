CREATE SEQUENCE managers_id_seq;
create table managers (
  id bigint not null DEFAULT NEXTVAL('managers_id_seq'),
  tips varchar(255) not NULL,
  users_id bigint DEFAULT NULL,
  primary key (id),
  CONSTRAINT fk_user
    FOREIGN KEY (users_id)
    REFERENCES users (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

);
ALTER SEQUENCE managers_id_seq OWNED BY users.id;