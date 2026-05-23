CREATE TABLE post_history(
    id serial PRIMARY KEY,
    changeDate DATE NOT NULL,
    HourChange TIME NOT NULL,
    id_publication integer NOT NULL,

    CONSTRAINT fk_idPublication_history
        FOREIGN KEY (id_publication) REFERENCES publication(id)

);

