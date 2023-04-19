-- liquibase formatted sql

-- changeset <gdp>:<insert-in-roles>
INSERT INTO roles(name) VALUES('ADMIN');
INSERT INTO roles(name) VALUES('USER');

-- rollback delete from roles;
