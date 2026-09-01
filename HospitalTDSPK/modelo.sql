create table tb_paciente(
    id number generated always as identity,
    nome varchar(100) not null,
    telefone varchar(30) not null,
    nascimento date,
    primary key(id)
);

create table tb_endereco(
    paciente_id number,
    logradouro varchar(150) not null,
    bairro varchar(40),
    numero varchar(20) not null,
    cep varchar(15) not null,
    tipo varchar(20) not null,
    foreign key(paciente_id) references tb_paciente(id)
);

create table tb_medico(
    id number generated always as identity,
    nome varchar(100) not null,
    crm varchar(15),
    especialidade varchar(50),
    primary key(id)
);

create sequence senha_seq;
select senha_seq.nextval from dual
