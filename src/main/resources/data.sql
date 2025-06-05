-- Создание таблицы OrgRegistration
CREATE TABLE org_registration (
    id SERIAL PRIMARY KEY,
    name_full VARCHAR(255) NOT NULL,
    name_short VARCHAR(100) NOT NULL
);

-- Создание таблицы OrgLegForm
CREATE TABLE org_leg_form (
    id SERIAL PRIMARY KEY,
    name_full VARCHAR(255) NOT NULL,
    name_short VARCHAR(100) NOT NULL
);

-- Создание таблицы Company
CREATE TABLE company (
    id SERIAL PRIMARY KEY,
    ogr_registration_id INTEGER REFERENCES org_registration(id),
    org_leg_form_id INTEGER REFERENCES org_leg_form(id),
    name_full VARCHAR(255) NOT NULL,
    name_short VARCHAR(100) NOT NULL,
    number_reg VARCHAR(50) NOT NULL,
    data_reg DATE NOT NULL
);

-- Создание таблицы Person
CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    shifer VARCHAR(50) NOT NULL,
    inn VARCHAR(12) NOT NULL,
    type VARCHAR(20) NOT NULL CHECK (type IN ('PHYSICAL', 'LEGAL')),
    data DATE NOT NULL
);

-- Наполнение тестовыми данными
INSERT INTO org_registration (name_full, name_short) VALUES
('Федеральная налоговая служба', 'ФНС'),
('Министерство юстиции', 'Минюст');

INSERT INTO org_leg_form (name_full, name_short) VALUES
('Общество с ограниченной ответственностью', 'ООО'),
('Акционерное общество', 'АО');

INSERT INTO company (ogr_registration_id, org_leg_form_id, name_full, name_short, number_reg, data_reg) VALUES
(1, 1, 'ООО Ромашка', 'Ромашка', '1234567890', '2023-01-15'),
(2, 2, 'АО Солнышко', 'Солнышко', '0987654321', '2022-06-20');

INSERT INTO person (shifer, inn, type, data) VALUES
('SHF001', '123456789012', 'PHYSICAL', '2023-03-10'),
('SHF002', '987654321098', 'LEGAL', '2022-09-25');