DROP TABLE IF EXISTS subject;

CREATE TABLE subject(
    id          INTEGER AUTO_INCREMENT PRIMARY KEY,
    code        VARCHAR(10) NOT NULL,
    name        VARCHAR(50) NOT NULL,
    credits     INTEGER NOT NULL
);

INSERT INTO subject(code, name, credits)
VALUES ('FDP', 'Fundamentos De Programación', 3),
       ('FADA', 'Fundamentos De Analisis y Diseños De Algoritmos', 5),
       ('BD', 'Bases De Datos', 3),
       ('FIS-1', 'Fisica 1', 4),
       ('FIS-2', 'Fisica 2', 4),
       ('CAL-2', 'Calculo 2', 2),
       ('CAL-3', 'Calculo 3', 2);
