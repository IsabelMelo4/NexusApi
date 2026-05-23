CREATE TABLE publication(
    id serial PRIMARY KEY,
    id_user UUID,
    text VARCHAR(100),
    date_publication DATE,
    image bytea NOT NULL,


    CONSTRAINT fk_id_user
        FOREIGN KEY (id_user) REFERENCES user_table(id)


);