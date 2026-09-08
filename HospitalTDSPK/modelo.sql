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

create table tb_enfermeiro(
    id number generated always as identity,
    nome varchar(200),
    coren varchar(15),
    primary key(id)
);

create table tb_ficha(
    id number generated always as identity,
    chegada date not null,
    sintomas varchar(200),
    diagnostico varchar(200),
    risco varchar(30),
    status varchar(30),
    paciente_id number,
    enfermeiro_id number,
    medico_id number,
    primary key(id),
    foreign key(paciente_id) references tb_paciente(id),
    foreign key(enfermeiro_id) references tb_enfermeiro(id),
    foreign key(medico_id) references tb_medico(id)
);



create sequence senha_seq;
select senha_seq.nextval from dual
