alter table plates drop column users_id;
alter table plates add column car_id bigint not NULL;
alter table plates add constraint fk_plate_car
FOREIGN KEY (car_id)
REFERENCES cars (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;