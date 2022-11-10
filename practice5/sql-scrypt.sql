CREATE TABLE cinema(
    id serial PRIMARY KEY,
    model text NOT NULL,
    material text NOT NULL,
    typeOfCinema text NOT NULL,
    price integer NOT NULL,
    volume integer NOT NULL
);
INSERT INTO cinema (id, model, material, typeOfСinema, price, volume) VALUES (1, 'kap4', 'birch wood', 'imax', 2000000, 300);
INSERT INTO cinema (id, model, material, typeOfСinema, price, volume) VALUES (2, '5star', 'oak wood', 'std', 1000000, 150);
INSERT INTO cinema (id, model, material, typeOfСinema, price, volume) VALUES (3, 'space', 'oak wood', 'seasonal', 1754321, 280);

CREATE TABLE users(
    id serial PRIMARY KEY,
    password varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    username varchar(255) NOT NULL,
);
INSERT INTO furniture (id, password , role, username) VALUES (1, '$4a$cOpM8HswvXuZLDcKJH5g', 'ROLE_ADMIN', 'admin');
INSERT INTO furniture (id, password , role, username) VALUES (2, '$4a$cOpM8HswvXuZLDcKJH5g', 'ROLE_USER', 'Pharise');