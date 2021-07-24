INSERT INTO doctors (first_name, last_name, patronymic, work_position, birth_date, phone_number)
VALUES ('Carl', 'White', 'CW', 'Main doctor', '1992-04-21', '+3807437274'),
       ('Marry', 'Black', 'MB', 'Second doctor', '1998-08-27', '+3803847289'),
       ('Tom', 'Pink', 'TP', 'Third doctor', '1989-01-04', '+3808924937'),
       ('Jack', 'Green', 'JG', 'Fourth doctor', '1982-12-14', '+380964567'),
       ('Tom', 'Pink', 'TP', 'Fifth doctor', '1991-03-11', '+3808687878');

INSERT INTO patients (first_name, last_name, patronymic, birth_date, doctor_id, phone_number)
VALUES ('Mike', 'Blue', 'MB', '1993-10-21', 1, '+380655374'),
       ('Jane', 'Yellow', 'JY', '1978-08-27', 1, '+38012131389'),
       ('Cris', 'Dark', 'CD', '1997-01-04', 2, '+3808865437'),
       ('Ann', 'Grey', 'AG', '2000-11-23', 3, '+38025362562'),
       ('Alice', 'Orange', 'AO', '1989-03-30', 3, '+380212121'),
       ('Harry', 'Orange', 'HO', '1991-06-24', 3, '+3807878788'),
       ('Alex', 'Brown', 'AB', '1995-01-04', 4, '+3809876544'),
       ('Tom', 'Red', 'TR', '1992-01-04', 4, '+3804566789'),
       ('Margo', 'Purple', 'CP', '2001-07-11', 4, '+3804747474'),
       ('Bob', 'Sun', 'BS', '2004-10-10', 5, '+3809988998');