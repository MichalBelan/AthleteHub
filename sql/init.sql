-- Vytvorenie používateľa
CREATE USER admin WITH PASSWORD 'admin';

-- Vytvorenie schémy (voliteľné, ak už existuje)
-- CREATE SCHEMA IF NOT EXISTS public;

-- Udelenie práv na schému
GRANT ALL PRIVILEGES ON SCHEMA public TO admin;

-- Vytvorenie tabuliek
CREATE TABLE user_system (
                             id BIGSERIAL PRIMARY KEY,
                             email VARCHAR(255),
                             name VARCHAR(255),
                             password VARCHAR(255),
                             role VARCHAR(255) NOT NULL
);

CREATE TABLE exercise (
                          id BIGSERIAL PRIMARY KEY,
                          description VARCHAR(255),
                          duration INTEGER
);

CREATE TABLE goal (
                      id BIGSERIAL PRIMARY KEY,
                      athlete_id BIGINT,
                      description VARCHAR(255),
                      target_date DATE
);

CREATE TABLE performance (
                             id BIGSERIAL PRIMARY KEY,
                             athlete_id BIGINT,
                             exercise_id BIGINT,
                             result NUMERIC(10,2)
);

CREATE TABLE training_plan (
                               id BIGSERIAL PRIMARY KEY,
                               athlete_id BIGINT,
                               schedule DATE,
                               title VARCHAR(255)
);

CREATE TABLE notification (
                              id BIGSERIAL PRIMARY KEY,
                              message VARCHAR(255),
                              read BOOLEAN,
                              user_id BIGINT
);

-- Udelenie práv na všetky tabuľky v public schéme
GRANT ALL PRIVILEGES ON DATABASE postgres TO admin;
GRANT ALL PRIVILEGES ON SCHEMA public TO admin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO admin;
