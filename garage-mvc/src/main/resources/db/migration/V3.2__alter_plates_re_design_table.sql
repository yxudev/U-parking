

CREATE SEQUENCE plates_id_seq;
create table plates (
                        id bigint not null DEFAULT NEXTVAL('plates_id_seq'),
                        license_number varchar(255) not NULL,
                        state varchar(255) not NULL,
                        cars_id bigint DEFAULT NULL,
                        primary key (id),
                        CONSTRAINT fk_car
                            FOREIGN KEY (cars_id)
                                REFERENCES cars (id)
                                ON DELETE NO ACTION
                                ON UPDATE NO ACTION

);
ALTER SEQUENCE plates_id_seq OWNED BY plates.id;
