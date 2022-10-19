--liquibase formatted sql

--changeset brakovchen:1
CREATE INDEX search_student ON student(name);

--changeset brakovchen:2
CREATE INDEX search_faculty_of_color_or_name ON faculty(color, name);

--changeset brakovchen:3
CREATE TABLE u(
    id INTEGER,
    name varchar
);

