-- liquibase formatted sql

-- changeset <gdp>:<create-roles>
CREATE TABLE IF NOT EXISTS roles (
    id   bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name)
    );

-- rollback drop table roles;
