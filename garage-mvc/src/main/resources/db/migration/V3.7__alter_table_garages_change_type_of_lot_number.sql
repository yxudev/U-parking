alter table garages drop column lot_number;
alter table garages add column lot_number bigint default null;