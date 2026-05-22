CREATE TABLE postHistory(
    id serial PRIMARY KEY,
    changeDate DATE NOT NULL,
    HourChange TIME NOT NULL,
    id_publication integer NOT NULL,

    CONSTRAINT fk_idPublicationHistory
        FOREIGN KEY (id_publication) REFERENCES publication(id)

);

