-- Create the user/schema for HR application
CREATE USER hrapplication IDENTIFIED BY [your_password]
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON users;

GRANT CONNECT, RESOURCE TO hrapplication;

-- Connect to the new schema
ALTER SESSION SET CURRENT_SCHEMA = hrapplication;

-- Create sequence for employee IDs
CREATE SEQUENCE employee_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

-- Create the employee table with required fields
CREATE TABLE employees (
                           employee_id VARCHAR2(20) PRIMARY KEY,
                           first_name VARCHAR2(50) NOT NULL,
                           last_name VARCHAR2(50) NOT NULL,
                           title VARCHAR2(50),
                           division VARCHAR2(50),
                           building VARCHAR2(20),
                           room VARCHAR2(20)
);

-- Insert sample data matching your XML structure
INSERT INTO employees (employee_id, first_name, last_name, title, division, building, room)
VALUES ('129', 'Jane', 'Doe', 'Engineer', 'Materials', '327', '19');

INSERT INTO employees (employee_id, first_name, last_name, title, division, building, room)
VALUES ('130', 'William', 'Defoe', 'Accountant', 'Accts Payable', '326', '14a');

INSERT INTO employees (employee_id, first_name, last_name, title, division, building, room)
VALUES ('131', 'Jack', 'Dee', 'Engineering Manager', 'Materials', '327', '21');

INSERT INTO employees (employee_id, first_name, last_name, title, division, building, room)
VALUES ('132', 'Sandra', 'Rogers', 'Engineering', 'Materials', '327', '22');

INSERT INTO employees (employee_id, first_name, last_name, title, division, building, room)
VALUES ('133', 'Steve', 'Casey', 'Engineering', 'Materials', '327', '24');

INSERT INTO employees (employee_id, first_name, last_name, title, division, building, room)
VALUES ('135', 'Michelle', 'Michaels', 'COO', 'Management', '216', '264');

COMMIT;

-- Create indexes for better performance
CREATE INDEX idx_employees_name ON employees(last_name, first_name);
CREATE INDEX idx_employees_division ON employees(division);
CREATE INDEX idx_employees_building ON employees(building);