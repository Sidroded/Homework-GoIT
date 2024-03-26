CREATE TABLE worker (
    ID bigint PRIMARY KEY AUTO_INCREMENT,
    NAME varchar(1000) check (LENGTH(NAME) >= 2),
    BIRTHDAY date CHECK (YEAR(BIRTHDAY) > 1900),
    LEVEL ENUM('Trainee', 'Junior', 'Middle', 'Senior'),
    SALARY int check(SALARY > 100 and SALARY < 100000)
);

CREATE TABLE client(
    ID bigint PRIMARY KEY AUTO_INCREMENT,
    NAME varchar(1000) check (LENGTH(NAME) >= 2)
);

CREATE TABLE project (
    ID bigint PRIMARY KEY AUTO_INCREMENT,
    CLIENT_ID bigint,
    START_DATE date,
    FINISH_DATE date,
    FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
);

CREATE TABLE project_worker (
    PROJECT_ID bigint,
    WORKER_ID bigint,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
    FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);
