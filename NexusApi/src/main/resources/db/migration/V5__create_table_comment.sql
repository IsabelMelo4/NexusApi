    CREATE TABLE comment (
        id SERIAL PRIMARY KEY,
        id_user UUID,
        id_publication INTEGER,
        text VARCHAR(255),

        CONSTRAINT fk_comment_usuario
           FOREIGN KEY (id_user) REFERENCES userTable(id),

        CONSTRAINT fk_comment_publication
            FOREIGN KEY (id_publication) REFERENCES publication(id)
    );