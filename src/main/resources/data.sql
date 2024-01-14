-- src/main/resources/data.sql
-- SPECIALIZARI
INSERT INTO SPECIALIZATION (id, nume) VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Cardiologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('c0e48d7a-3095-4c21-8c21-c6e3ebbe0d6d', 'Ortopedie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('f56d992a-6ec0-4f32-843d-7199ea16fde0', 'Neurologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('8d2db0f1-aa9e-4d5d-8d2f-df3c6bd507e9', 'Oncologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('3b1d3f01-0c20-43ea-a571-d5cfa8f02d0c', 'Ginecologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('d9a925a7-c738-446d-8247-1271ee2c44cd', 'Pediatrie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('6c18143a-c50c-4e1a-9767-5c2d33c4d46c', 'Dermatologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('35c60d5c-8971-4c88-9079-89a9a4f4ceef', 'Urologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('1b913edb-33c3-4d61-8d79-37ef6970a993', 'Oftalmologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('b8f8a503-84d5-431e-b176-b00b50a4d3c6', 'Endocrinologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('a19f4aa7-e7e4-4e53-9bd2-d23f3e11874e', 'Chirurgie generală') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('2eeedc24-63fe-465a-9ad5-91946e82689a', 'Radiologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('e29b164c-d0ab-4fc7-a8fb-5b21f5bd5cf0', 'Psihiatrie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('2412bc34-9c88-4fb4-85f7-083b8c1f1984', 'Gastroenterologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('db1c0e24-fa5d-415e-b0eb-0b7f123a758e', 'Hematologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('68948798-646b-4a6a-9d25-fc3521a08b1a', 'Reumatologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('0a58a0e1-07af-4e85-8702-4b82da346b67', 'Nefrologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('d94b2382-dc33-4a7d-8eb4-1945d973f321', 'Otorinolaringologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('8bf253f0-77eb-4813-8d33-098f24218a97', 'Imunologie') ON CONFLICT DO NOTHING;
INSERT INTO SPECIALIZATION (id, nume) VALUES ('a01f62e0-0d8e-4e57-b2ad-1b7a9f52be0d', 'Anestezie și terapie intensivă') ON CONFLICT DO NOTHING;

-- SPITALE
INSERT INTO hospital (id, nume, adresa) VALUES
    ('c1a461d5-4fb9-4b62-b29c-96aa66b8d06a', 'Hospital1', 'Address1')
ON CONFLICT DO NOTHING;

INSERT INTO hospital (id, nume, adresa) VALUES
    ('c1a461d5-4fb9-4b62-b29c-96aa66b8d06b', 'Hospital2', 'Address2')
ON CONFLICT DO NOTHING;

INSERT INTO hospital (id, nume, adresa) VALUES
    ('c1a461d5-4fb9-4b62-b29c-96aa66b8d06c', 'Hospital3', 'Address3')
ON CONFLICT DO NOTHING;

INSERT INTO hospital (id, nume, adresa) VALUES
    ('c1a461d5-4fb9-4b62-b29c-96aa66b8d06d', 'Hospital4', 'Address4')
ON CONFLICT DO NOTHING;

INSERT INTO hospital (id, nume, adresa) VALUES
    ('c1a461d5-4fb9-4b62-b29c-96aa66b8d06e', 'Hospital5', 'Address5')
ON CONFLICT DO NOTHING;

INSERT INTO hospital (id, nume, adresa) VALUES
    ('c1a461d5-4fb9-4b62-b29c-96aa66b8d06f', 'Hospital6', 'Address6')
ON CONFLICT DO NOTHING;

-- LEGATURI SPITAL-SPECIALIZARI

-- Linking specialization 'Cardiologie' with hospitals
INSERT INTO specialization_hospitals (specialization_id, hospital_id)
VALUES
    ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'c1a461d5-4fb9-4b62-b29c-96aa66b8d06a') ON CONFLICT DO NOTHING;

INSERT INTO specialization_hospitals (specialization_id, hospital_id)
VALUES
    ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'c1a461d5-4fb9-4b62-b29c-96aa66b8d06b') ON CONFLICT DO NOTHING;

-- Linking specialization 'Ortopedie' with hospitals
INSERT INTO specialization_hospitals (specialization_id, hospital_id)
VALUES
    ('c0e48d7a-3095-4c21-8c21-c6e3ebbe0d6d', 'c1a461d5-4fb9-4b62-b29c-96aa66b8d06c') ON CONFLICT DO NOTHING;

INSERT INTO specialization_hospitals (specialization_id, hospital_id)
VALUES
    ('c0e48d7a-3095-4c21-8c21-c6e3ebbe0d6d', 'c1a461d5-4fb9-4b62-b29c-96aa66b8d06d') ON CONFLICT DO NOTHING;

INSERT INTO specialization_hospitals (specialization_id, hospital_id)
VALUES
    ('68948798-646b-4a6a-9d25-fc3521a08b1a', 'c1a461d5-4fb9-4b62-b29c-96aa66b8d06e') ON CONFLICT DO NOTHING;

INSERT INTO specialization_hospitals (specialization_id, hospital_id)
VALUES
    ('a01f62e0-0d8e-4e57-b2ad-1b7a9f52be0d', 'c1a461d5-4fb9-4b62-b29c-96aa66b8d06f') ON CONFLICT DO NOTHING;

-- Add more similar insert statements for other specializations and hospitals

