alter table cars drop column vin;
alter table cars add column vin varchar(255) not NULL;