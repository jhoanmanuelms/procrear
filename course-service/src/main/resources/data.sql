DROP TABLE IF EXISTS course;

CREATE TABLE course(
    id                  INTEGER AUTO_INCREMENT PRIMARY KEY,
    studentCode         INTEGER NOT NULL,
    subjectCode         VARCHAR(10) NOT NULL,
    grade               NUMERIC NULL
);

INSERT INTO course(studentcode, subjectcode, grade) VALUES (123456, 'FDP', 0.0);
