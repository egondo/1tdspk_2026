CREATE TABLE task(
    id number generated always as identity,
    titulo varchar(50) not null,
    descricao varchar(200) not null,
    data date not null,
    prioridade varchar(15),
    status varchar(15),
    criacao timestamp,
    primary key(id)
);