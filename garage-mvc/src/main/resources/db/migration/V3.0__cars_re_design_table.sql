CREATE SEQUENCE cars_id_seq;
    create table cars (
        id bigint not null DEFAULT NEXTVAL('cars_id_seq'),
        vin varchar(255) not NULL,
        model varchar(255) not NULL,
        type varchar(255) not NULL,
        garages_id bigint default null,
        plates_id bigint default null,
        primary key (id),

        CONSTRAINT fk_plates
        FOREIGN KEY (plates_id)
        REFERENCES plates (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,


        CONSTRAINT fk_garages
        FOREIGN KEY (garages_id)
        REFERENCES garages (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);
ALTER SEQUENCE cars_id_seq OWNED BY cars.id;
