alter table users drop column date_of_birth;
alter table users add column date_of_birth TIMESTAMP not NULL;