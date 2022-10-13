create database fridge owner postgres;
\connect fridge
CREATE TABLE fridge (
     seria int,
     views varchar,
     brand varchar,
     country varchar,
     height int,
     width int,
     depth int
);