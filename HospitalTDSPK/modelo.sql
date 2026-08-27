create table tb_paciente(
    id number generated always as identity,
    nome varchar(100) not null,
    telefone varchar(30) not null,
    nascimento date,
    primary key(id)
);

create table tb_medico(
    id number generated always as identity,
    nome varchar(100) not null,
    crm varchar(15),
    especialidade varchar(50),
    primary key(id)
);