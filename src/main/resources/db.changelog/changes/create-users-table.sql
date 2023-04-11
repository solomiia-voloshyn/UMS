create table users (
  id bigserial not null,
  first_name varchar(255),
  last_name varchar(255),
  password varchar(255),
  status varchar(255),
  username varchar(255) unique,
  primary key (id)
);