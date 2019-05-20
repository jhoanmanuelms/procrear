DROP TABLE IF EXISTS student;

CREATE TABLE student(
    id                  INTEGER AUTO_INCREMENT PRIMARY KEY,
    code                INTEGER NOT NULL,
    name                VARCHAR(50) NOT NULL,
    lastName            VARCHAR(50) NOT NULL,
    availableCredits    INTEGER NOT NULL
);

INSERT INTO student(code, name, lastName, availableCredits)
VALUES (123456, 'Jhoan', 'Munoz', 16),
       (7891011, 'Jane', 'Doe', 20);
