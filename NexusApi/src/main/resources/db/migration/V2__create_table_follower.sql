CREATE TABLE follower (
    id UUID PRIMARY KEY,

    usuario_id UUID NOT NULL,
    seguidor_id UUID NOT NULL,
    status VARCHAR NOT NULL,
    date_follow TIMESTAMP NOT NULL,

    CONSTRAINT fk_usuario
        FOREIGN KEY (usuario_id) REFERENCES user_table(id),

    CONSTRAINT fk_seguidor
     FOREIGN KEY (seguidor_id) REFERENCES user_table(id)

);