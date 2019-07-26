alter table time_duration drop column parking_min;
alter table time_duration add column parking_min int default null;
alter table time_duration drop column parking_days;
alter table time_duration add column parking_days int default null;
