CREATE TABLE car(
    id REAL,
    type varchar NOT NULL,
    model varchar NOT NULL,
    price NUMERIC,
    auto_id varchar REFERENCES person(name)

);

CREATE TABLE person(
  id REAL,
  name varchar NOT NULL PRIMARY KEY,
  driver_license varchar CONSTRAINT driver_licence DEFAULT('yes')

);