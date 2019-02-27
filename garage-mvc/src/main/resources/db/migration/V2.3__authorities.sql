CREATE SEQUENCE authorities_id_seq;
create table authorities (
   id bigint not null DEFAULT NEXTVAL('authorities_id_seq'),
   user_id bigint not null,
   authority varchar(255) not null,
   primary key (id),

   CONSTRAINT fk_authorities
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
ALTER SEQUENCE authorities_id_seq OWNED BY authorities.id;
