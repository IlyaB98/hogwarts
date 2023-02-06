CREATE TABLE peoples
(
    name           TEXT PRIMARY KEY NOT NULL,
    age            INTEGER          NOT NULL,
    driver_license BOOLEAN          NOT NULL,
    car_id         UUID REFERENCES cars (id)
);

CREATE TABLE cars
(
    id UUID PRIMARY KEY  NOT NULL,
    brand CHAR     NOT NULL,
    model CHAR     NOT NULL,
    price INTEGER  NOT NULL
);



