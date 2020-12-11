use aquarius;
 -- create database aquarius;
 -- drop database aquarius;
create table if not exists modalidade(
    id   int auto_increment not null primary key,
    nome varchar(255)       not null
);

create table if not exists professor(
    id              int auto_increment not null primary key,
    nome            varchar(255)       not null,
    cpf varchar(255) not null unique ,
    data_nascimento date
);

create table if not exists estado(
    id   int auto_increment not null primary key,
    nome varchar(50) unique
);

create table if not exists cidade(
    id        int auto_increment not null primary key,
    nome      varchar(255),
    estado_id int                not null,
    INDEX `fk_cidade_estado_idx` (`estado_id` ASC),
    CONSTRAINT `fk_cidade_estado` FOREIGN KEY (`estado_id`) REFERENCES `estado` (id)
);

create table if not exists aluno(
    id int auto_increment not null primary key ,
    cpf varchar(16) not null unique ,
    data_nascimento DATE NOT NULL,
    cuidado_especial boolean NOT NULL,
    nome varchar(255) not null ,
    tipo_cuidado varchar(255) not null ,
    email varchar(255) not null unique
);

create table if not exists endereco(
    id      int auto_increment not null primary key ,
    logradouro varchar(255) not null ,
    numero varchar(50) not null ,
    complemento varchar(255) not null ,
    bairro varchar(255) not null ,
    cep varchar(10) not null,
    cidade_id int not null,
    aluno_id int not null,
    INDEX `fk_endereco_cidade_idx` (`cidade_id`),
    INDEX `fk_endereco_aluno_idx` (`aluno_id`),
    CONSTRAINT `fk_endereco_cidade` FOREIGN KEY (cidade_id) REFERENCES `cidade` (id),
    CONSTRAINT `fk_endereco_aluno` FOREIGN KEY (aluno_id) REFERENCES `aluno` (id)
);

create table if not exists pagamento(
    id int auto_increment not null primary key ,
    data_vencimento DATE not null,
    forma_pagamento varchar(255) not null,
    valor DOUBLE not null,
    pago boolean not null,
    aluno_id int not null,
    INDEX `fk_pagamento_aluno_idx` (`aluno_id`),
    CONSTRAINT `fk_pagamento_aluno` FOREIGN KEY (aluno_id) REFERENCES aluno (id)
);

create table telefone(
    aluno_id int NOT NULL ,
    telefones varchar(255) not null,
    UNIQUE INDEX `fk_aluno_telefone_idx` (aluno_id, telefones)
);

create table atestado(
    id int not null auto_increment primary key ,
    data_inicio DATE not null ,
    data_fim DATE not null,
    aluno_id int not null ,
    INDEX `fk_atestado_aluno_idx` (`aluno_id`),
    CONSTRAINT `fk_atestado_aluno` FOREIGN KEY (aluno_id) references aluno (id)
);
