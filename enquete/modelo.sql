create table pergunta(
    id number generated always as identity,
    numero number(2, 0),
    texto varchar(200),
    tipo varchar(15),
    primary key(id)
);

create table alternativa (
    id number generated always as identity,
    texto varchar(200),
    id_pergunta number,
    primary key(id),
    foreign key (id_pergunta) references pergunta(id)
);

create table resposta(
    id number generated always as identity,
    valor varchar(200),
    id_pergunta number,
    primary key(id),
    foreign key (id_pergunta) references pergunta(id)
);


create table resposta_alternativa(
    id_resposta number,
    id_alternativa number,
    foreign key (id_resposta) references resposta(id),
    foreign key (id_alternativa) references alternativa(id)
);