CREATE TABLE publication_status(
    id serial PRIMARY KEY,
    newStatus varchar NOT NULL,
    oldStatus varchar NOT NULL,
    statusType varchar,
    id_publication integer,

    CONSTRAINT fk_publication_status
        FOREIGN KEY(id_publication) REFERENCES publication(id)

);