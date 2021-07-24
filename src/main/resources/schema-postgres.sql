CREATE TABLE IF NOT EXISTS doctors (
	id BIGSERIAL not null PRIMARY KEY,
	first_name VARCHAR(128) not null,
    last_name VARCHAR(128) not null,
    patronymic VARCHAR(128) not null,
    work_position VARCHAR(128) not null,
    birth_date DATE not null,
    phone_number VARCHAR(128) not null
);

CREATE TABLE IF NOT EXISTS patients (
	id BIGSERIAL not null PRIMARY KEY,
	first_name VARCHAR(128) not null,
    last_name VARCHAR(128) not null,
    patronymic VARCHAR(128) not null,
    birth_date DATE not null,
    doctor_id BIGSERIAL not null,
    phone_number VARCHAR(128) not null,
    FOREIGN KEY (doctor_id) REFERENCES doctors (id) on delete cascade
);