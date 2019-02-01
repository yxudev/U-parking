alter table users add CONSTRAINT username_unique UNIQUE (username);
alter table users add CONSTRAINT email_unique UNIQUE (email);
alter table users add CONSTRAINT phone_number_unique UNIQUE (phone_number);