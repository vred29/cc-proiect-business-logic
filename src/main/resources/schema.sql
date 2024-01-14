create table if not exists hospital
(
    id     uuid not null
        primary key,
    adresa varchar(255),
    nume   varchar(255)
);

create table if not exists specialization
(
    id   uuid not null
        primary key,
    nume varchar(255)
);

create table if not exists specialization_hospitals
(
    specialization_id uuid not null
        constraint specialization_fk
            references specialization,
    hospital_id       uuid not null
        constraint hospital_fk
            references hospital,
    constraint spcialization_hospital_unique
        unique (specialization_id, hospital_id)
);

alter table specialization_hospitals
    owner to appointments;

alter table specialization
    owner to appointments;

alter table hospital
    owner to appointments;