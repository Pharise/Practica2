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