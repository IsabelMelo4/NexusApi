CREATE TABLE likes (
    id SERIAL PRIMARY KEY,
    id_user UUID,
    id_publication INTEGER,

    CONSTRAINT fk_like_usuario
        FOREIGN KEY (id_user) REFERENCES userTable(id),

    CONSTRAINT fk_like_publication
        FOREIGN KEY (id_publication) REFERENCES publication(id)
);