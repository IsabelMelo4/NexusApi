CREATE TABLE follower (
    id SERIAL PRIMARY KEY,

    usuario_id UUID NOT NULL,
    seguidor_id UUID NOT NULL,

    CONSTRAINT fk_usuario
        FOREIGN KEY (usuario_id) REFERENCES userTable(id),

    CONSTRAINT fk_seguidor
     FOREIGN KEY (seguidor_id) REFERENCES userTable(id)

);