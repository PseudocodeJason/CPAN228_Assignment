create table if not exists item (
  id identity,
  name varchar(50) not null,
  brandForm varchar(50) not null,
  yearOfCreation int not null,
  price numeric not null
);